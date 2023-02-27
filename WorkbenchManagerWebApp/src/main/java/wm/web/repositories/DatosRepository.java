package wm.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import wm.web.entities.Datos;

public interface DatosRepository extends JpaRepository<Datos, String> {

}
