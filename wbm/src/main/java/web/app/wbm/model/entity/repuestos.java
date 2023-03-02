package web.app.wbm.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
