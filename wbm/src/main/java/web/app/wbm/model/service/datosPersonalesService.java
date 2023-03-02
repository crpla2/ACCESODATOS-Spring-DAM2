package web.app.wbm.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import web.app.wbm.model.entity.datos_personales;
import web.app.wbm.repository.DatosRepository;

@Service
public class datosPersonalesService {
	 @Autowired
	    DatosRepository datosRepo;

	    public List<datos_personales> getList(){
	        return datosRepo.findAll();
	    }

	    public Optional<datos_personales> getDatosdDni(String id){
	        return datosRepo.findById(id);
	    }
    
	    public void save(datos_personales datos){
	        datosRepo.save(datos);
	    }
	   
	    public boolean existsProductoId(String id){
	        return datosRepo.existsById(id);
	    }

	   
}
