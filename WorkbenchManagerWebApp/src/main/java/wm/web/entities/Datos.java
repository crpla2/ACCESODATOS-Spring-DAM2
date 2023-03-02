package wm.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Datos {
	@Id
	@Column(nullable = false, length = 9)
	private String dni;
	@Column(nullable = false, length = 45)
	private String apellidos;
	@Column(nullable = false, length = 45)
	private String nombre;
	@Column(nullable = false, length = 100)
	private String direccion;
	@Column(nullable = false, length = 9)
	private String telefono;
	@Column(nullable = true, length = 45)
	private String email;

}
