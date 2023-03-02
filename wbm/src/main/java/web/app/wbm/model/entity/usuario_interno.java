package web.app.wbm.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
