package taller.web.WorkbenchManager.model.entity;

import java.io.Serializable;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{
	
	@Id
	private String dni;
	
	@Column(name="idUsuario")
	@Nullable
	private int id;
	
	@OneToOne
	private Datos datos;
}
