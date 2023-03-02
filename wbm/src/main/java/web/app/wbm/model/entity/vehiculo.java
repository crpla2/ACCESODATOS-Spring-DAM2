package web.app.wbm.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
}
