package web.app.wbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.wbm.model.entity.datos_personales;



public interface DatosRepository extends JpaRepository<datos_personales, String> {

}
