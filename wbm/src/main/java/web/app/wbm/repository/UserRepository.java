package web.app.wbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.app.wbm.model.entity.usuario_web;

public interface UserRepository extends JpaRepository<usuario_web, String> {

	@Query("SELECT u FROM usuario_web u WHERE u.email = ?1")
	public usuario_web findByEmail(String username);

}
