package web.app.wbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import web.app.wbm.model.entity.vehiculo;

public interface VehiculoRepository extends JpaRepository<vehiculo, String>{
	
	@Query("select dp from vehiculo dp where dp.propietario.dni = :dni and dp.alta=true")
	public List<vehiculo> findAllByDni(@Param("dni") String dni);
	@Query("select dp from vehiculo dp where dp.matricula = :matricula and dp.alta=true")
	public vehiculo findByMatricula(@Param("matricula") String matricula);
	
}
