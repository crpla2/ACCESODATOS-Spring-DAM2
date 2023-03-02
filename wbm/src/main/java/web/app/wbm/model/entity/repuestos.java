package web.app.wbm.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class repuestos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRepuestos;    
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    private BigDecimal precio; 
    @Column(nullable = false)
    private Integer stock;
}
