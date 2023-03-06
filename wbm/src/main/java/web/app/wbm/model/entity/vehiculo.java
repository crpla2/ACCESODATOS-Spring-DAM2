package web.app.wbm.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class vehiculo {	

	@Id
	@Column(nullable = false, length = 7)
	private String matricula;
	@JoinColumn(name = "cliente_dni", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private datos_personales propietario;
	@Enumerated(EnumType.STRING)
	@Column(name="tipo")
	private Tipo tipo;
	@Column(nullable = false, length = 45)
	private String marca;
	@Column(nullable = false, length = 45)
	private String modelo;
	@Column( nullable= false, length = 4)
	private String anio;
	@Column( nullable= false)
	private boolean alta;
}
