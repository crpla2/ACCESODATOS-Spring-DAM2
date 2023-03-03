package web.app.wbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import web.app.wbm.model.entity.usuario_web;

public interface UsuarioWebRepository extends JpaRepository<usuario_web, String> {

	
	@Query("select uw from usuario_web uw where uw.email = :email")
	public usuario_web findByUsuario(@Param("email") String email);

	
	
}
