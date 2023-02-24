package taller.web.WorkbenchManager.model.dao;

import org.springframework.transaction.annotation.Transactional;

import com.openwebinars.spring.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import taller.web.WorkbenchManager.model.entity.Datos;

public class DatosDao {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public Datos findById(long id) {
		Datos result = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < repositorio.size()) {
			if (repositorio.get(i).getId() == id) {
				encontrado = true;
				result = repositorio.get(i);
			} else {
				i++;
			}
		}
		
		return result;
	}
}
