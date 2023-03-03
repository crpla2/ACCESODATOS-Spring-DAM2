package web.app.wbm.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.app.wbm.exception.ResourceFoundException;
import web.app.wbm.exception.ResourceNotFoundException;
import web.app.wbm.model.entity.usuario_web;
import web.app.wbm.repository.DatosPersonalesRepository;
import web.app.wbm.repository.UsuarioWebRepository;

@Service
public class usuarioWebService {
	@Autowired
	UsuarioWebRepository usuarioWebRepository;
	@Autowired
	DatosPersonalesRepository datosPersonalesRepository;

	public usuario_web save(usuario_web user) throws ResourceFoundException, ResourceNotFoundException {
		if (usuarioWebRepository.findByUsuario(user.getEmail()) != null) {
			throw new ResourceFoundException("Usuario ya existente");
		}
		if (datosPersonalesRepository.findByDni(user.getDni()) == null) {
			throw new ResourceNotFoundException("Usuario no existente");
		}
		return usuarioWebRepository.save(user);
	}
}
