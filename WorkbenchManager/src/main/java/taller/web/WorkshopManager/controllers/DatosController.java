package taller.web.WorkshopManager.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;



import taller.web.WorkbenchManager.model.dao.DatosDao;
import taller.web.WorkbenchManager.model.entity.Datos;

@Controller
@SessionAttributes("DatosPersonales")
public class DatosController {

	@Autowired
	private DatosDao datosDao;

	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Datos cliente = null;
		
		if(id > 0) {
			cliente = DatosDao.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form";
	}
}