package web.app.wbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import web.app.wbm.model.entity.datos_personales;
import web.app.wbm.model.entity.usuario_web;
import web.app.wbm.repository.DatosPersonalesRepository;
import web.app.wbm.repository.UsuarioWebRepository;

@Controller
public class AppController {

	@Autowired
	private UsuarioWebRepository userRepo;
	@Autowired
	private DatosPersonalesRepository datosRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new usuario_web());

		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(usuario_web user) {

		if (datosRepo.existsById(user.getDni())) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			if (userRepo.existsById(user.getDni()) || userRepo.findByUsuario(user.getEmail()) != null) {
				return "register_fail";
			}
			userRepo.save(user);

			return "register_success";
		} else {
			return "register_fail";
		}
	}
	/*
	 * @GetMapping("/users") public String listUsers(Model model) { Object principal
	 * = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * UserDetails userDetails = null; if (principal instanceof UserDetails) {
	 * userDetails = (UserDetails) principal; } String userName =
	 * userDetails.getUsername(); usuario_web listUsers =
	 * userRepo.findByUsuario(userName); model.addAttribute("listUsers", listUsers);
	 * 
	 * datos_personales listDatos = datosRepo.findByDni(userName);
	 * model.addAttribute("listDatos", listDatos); return "users"; }
	 */

	@GetMapping("/users")
	public String listUsers(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		usuario_web listUsers = userRepo.findByUsuario(userName);
		model.addAttribute("listUsers", listUsers);
		
		datos_personales listDatos = datosRepo.findByDni(listUsers.getDni());
		model.addAttribute("listDatos", listDatos);
		model.addAttribute("nombre",listDatos.getNombreCompleto());
		
		return "users";
	}

	@GetMapping("/UpdateDatos")
	public String UpdateDatos(datos_personales user) {
		datos_personales listDatos = datosRepo.findByDni(user.getDni());
		listDatos.setTelefono(user.getTelefono());
		user.setDireccion(user.getDireccion());
		datosRepo.save(listDatos);

		return "redirect:users";

	}
}
