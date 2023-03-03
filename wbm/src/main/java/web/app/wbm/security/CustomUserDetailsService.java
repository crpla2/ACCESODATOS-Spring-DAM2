package web.app.wbm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import web.app.wbm.model.entity.usuario_web;
import web.app.wbm.repository.UsuarioWebRepository;


public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioWebRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		usuario_web user = userRepo.findByUsuario(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

}
