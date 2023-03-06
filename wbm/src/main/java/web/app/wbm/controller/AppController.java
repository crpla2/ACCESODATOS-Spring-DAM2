package web.app.wbm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.app.wbm.model.entity.datos_personales;
import web.app.wbm.model.entity.usuario_web;
import web.app.wbm.model.entity.vehiculo;
import web.app.wbm.repository.DatosPersonalesRepository;
import web.app.wbm.repository.UsuarioWebRepository;
import web.app.wbm.repository.VehiculoRepository;

@Controller
public class AppController {

	@Autowired
	private UsuarioWebRepository userRepo;
	@Autowired
	private DatosPersonalesRepository datosRepo;
	@Autowired
	private VehiculoRepository vehiculoRepo;

	public usuario_web getUsuario() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		return userRepo.findByUsuario(userName);
	}

	public datos_personales getDatos() {
		return datosRepo.findByDni(getUsuario().getDni());
	}

	@GetMapping(value = "/index")
	public String viewHomePage(Model model) {
		model.addAttribute("nombre", getDatos().getNombreCompleto());
		return "index";
	}

	@GetMapping(value = "/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new usuario_web());
		return "signup_form";
	}

	@PostMapping(value = "/process_register")
	public String processRegister(usuario_web user) {

		if (datosRepo.existsById(user.getDni())) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			datos_personales datos = datosRepo.findByDni(user.getDni());
			if (userRepo.existsById(user.getDni()) || userRepo.findByUsuario(user.getEmail()) != null || datos == null
					|| !datos.isCliente()) {
				return "register_fail";
			}
			userRepo.save(user);

			return "register_success";
		} else {
			return "register_fail";
		}
	}

	@GetMapping(value = "/users")
	public String listUsers(Model model) {

		model.addAttribute("listUsers", getUsuario());
		model.addAttribute("listDatos", getDatos());
		model.addAttribute("nombre", getDatos().getNombreCompleto());

		return "users";
	}

	@PostMapping(value = "/users")
	public String updateDatos(@RequestParam("dni") String dni, @RequestParam("telefono") String telefono,
			@RequestParam("direccion") String direccion) {
		datos_personales datos = datosRepo.findByDni(dni);
		datos.setTelefono(telefono);
		datos.setDireccion(direccion);
		datosRepo.save(datos);
		return "redirect:/users";
	}

	@GetMapping(value = "/users/passwd")
	public String updatePass(Model model) {

		model.addAttribute("nombre", getDatos().getNombreCompleto());

		return "cambioPass_form";
	}

	@PostMapping(value = "/users/passwd")
	public String updateDatos(@RequestParam("currentPasswd") String currentPasswd,
			@RequestParam("newPasswd") String newPasswd, @RequestParam("newPasswd2") String newPasswd2, Model model) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		if (!passwordEncoder.matches(currentPasswd, getUsuario().getPassword())) {
			model.addAttribute("error", "Contraseña incorrecta");
			return "cambioPass_form";
		}

		if (!newPasswd.equals(newPasswd2)) {
			model.addAttribute("error2", "Las contraseñas no coinciden");
			return "cambioPass_form";
		}

		usuario_web user = getUsuario();
		user.setPassword(passwordEncoder.encode(newPasswd));
		userRepo.save(user);

		return "redirect:/users";
	}

	@GetMapping(value = "/vehiculos")
	public String listVehiculos(Model model) {
		List<vehiculo> listacoches = vehiculoRepo.findAllByDni(getUsuario().getDni());
		model.addAttribute("listacoches", listacoches);
		model.addAttribute("nombre", getDatos().getNombreCompleto());

		return "listar";
	}

	@RequestMapping(value = "/vehiculos/eliminar/{matricula}")
	public String eliminarViculo(@PathVariable(value = "matricula") String matricula) {

		vehiculo vehiculo = vehiculoRepo.findByMatricula(matricula);
		vehiculo.setAlta(false);
		vehiculoRepo.save(vehiculo);
		return "redirect:/vehiculos";
	}

	@GetMapping(value = "/vehiculos/nuevo")
	public String nuevoVehiculo(Model model) {
		model.addAttribute("vehiculo", new vehiculo());
		return "vehiculo_form";
	}

	@PostMapping("/vehiculos/nuevo")
	public String updateDatos(vehiculo vehiculo, Model model) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		if (vehiculoRepo.findByMatricula(vehiculo.getMatricula()) != null) {
			if (vehiculoRepo.findByMatricula(vehiculo.getMatricula()).isAlta()) {
				model.addAttribute("error2", "Error, vehiculo dado de alta con otro propietario.");
				return "redirect:/vehiculos/nuevo";
			}
			model.addAttribute("error", "Vehiculo ya existente. ¿Desea darse de alta como su nuevo propietario?");
			return "redirect:/users";
		}

//		 usuario_web user= getUsuario(); 
//		 user.setPassword(passwordEncoder.encode(newPasswd));
//		 userRepo.save(user);

		return "redirect:/vehiculos";
	}

}
