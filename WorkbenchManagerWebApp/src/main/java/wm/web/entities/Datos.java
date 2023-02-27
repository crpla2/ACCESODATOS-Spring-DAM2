package wm.web.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Datos {
	@Id
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String email;

}
