package web.app.wbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import web.app.wbm.model.entity.datos_personales;



public interface DatosPersonalesRepository extends JpaRepository<datos_personales, String> {
	@Query("select dp from datos_personales dp where dp.dni = :dni")
	public datos_personales findByDni(@Param("dni") String dni);

}
