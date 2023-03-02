package web.app.wbm.model.entity;

import java.sql.Date;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class parte {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParte;
    
    @ManyToOne
    @JoinColumn(name = "idVehiculo")
    private vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "ClienteDni")
    private datos_personales cliente;
    
    @ManyToOne
    @JoinColumn(name = "idMecanico")
    private usuario_interno mecanico;
    
    @ManyToOne
    @JoinColumn(name = "idRepuestos")
    private repuestos rep;
    
    @Column(nullable = false)
    private Date fechaEntrada;
    
    @Column(nullable = true)
    private Date fechaSalida=null;
    
    @Column(nullable = false, length=3)
    private Integer horasEstimadas;
    
    @Column(nullable = true, length=3)
    private Integer horasReales=null;
    
    @Column(nullable = false)
    private Boolean estado=true;
    
    @Column(nullable = false)
    private Boolean facturado=false;
    
    @Column(nullable = false, length=11)
    private Integer kilometros;
}
