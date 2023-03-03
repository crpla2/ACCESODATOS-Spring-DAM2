package web.app.wbm.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	@Column(nullable = true)
	private boolean es_cliente;
	@OneToOne(mappedBy = "datos", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	
	private usuario_web usuario;

}
