package taller.web.WorkbenchManager.model.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="DatosPersonales")
public class Datos {

		@Id
		@OneToOne(mappedBy = "dni")
		@NotEmpty
		private String dni;
		@NotEmpty
		private String apellidos;
		@NotEmpty
		private String nombre;
		@NotEmpty
		private String dirección;
		
		@NotEmpty
		private String telefono;
		@Nullable
		@Email 
		private String email;
		
}
