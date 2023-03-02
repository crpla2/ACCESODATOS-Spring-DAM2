package web.app.wbm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class usuario_web {
	@Id
	@Column(nullable = false, length = 9)
	private String dni;
	@JoinColumn(name = "dni_usuario", nullable = false)
	@OneToOne 
	@MapsId
	private datos_personales usuario;
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(nullable = false, length = 64)
	private String password;
}
