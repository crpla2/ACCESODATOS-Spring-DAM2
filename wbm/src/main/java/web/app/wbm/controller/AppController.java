package web.app.wbm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.app.wbm.model.entity.usuario_web;
import web.app.wbm.repository.DatosRepository;
import web.app.wbm.repository.UserRepository;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DatosRepository datosRepo;

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
	//	Optional<datos_personales> data = datosRepo.findById(user.getDni());
	//	if (data.isPresent()) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userRepo.save(user);
			return "register_success";
	//	} else {
	//		return "register_fail";
	//	}
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		usuario_web listUsers = userRepo.findByEmail(userName);
		model.addAttribute("listUsers", listUsers);

		return "users";
	}
}
