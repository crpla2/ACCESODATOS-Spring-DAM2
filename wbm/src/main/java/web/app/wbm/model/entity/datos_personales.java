package web.app.wbm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class datos_personales {
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
