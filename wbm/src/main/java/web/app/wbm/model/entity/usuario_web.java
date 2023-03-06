package web.app.wbm.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Entity
public class usuario_web {

	@Id
	@Column(nullable = false, length = 9)
	private String dni;
	
	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = false, unique = true, length = 100)
	private String password;
	@OneToOne
	@JoinColumn(name = "dni")
	private datos_personales datos;
}