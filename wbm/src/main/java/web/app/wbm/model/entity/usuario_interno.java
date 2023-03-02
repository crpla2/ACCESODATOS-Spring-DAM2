package web.app.wbm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class usuario_interno {
	   
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	   
	    private int idUsuario;
	    
	    @Column(nullable = false, length=45)
	    private String usuario;
	    
	    @Column(nullable = false, length=8000)
	    private byte[] password;
	    
	    @Enumerated(EnumType.ORDINAL)
	    @Column(name = "rol")
	    private Rol rol;
	    
	    @Column(nullable = false, length=6)
	    private String sal;
}
