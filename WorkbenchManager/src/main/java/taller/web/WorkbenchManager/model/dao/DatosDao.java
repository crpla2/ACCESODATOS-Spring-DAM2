package taller.web.WorkbenchManager.model.dao;

import org.springframework.transaction.annotation.Transactional;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import taller.web.WorkbenchManager.model.entity.Datos;

public class DatosDao {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public Datos findOne(Long id) {
		return em.find(Datos.class, id);
	}
}
