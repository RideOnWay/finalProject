package com.sugggarCoffe.sub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.Repository.OtrosRepository;
import com.sugggarCoffe.sub.model.Otros;

@Service
public class OtrosService {

	@Autowired
	private final OtrosRepository otrosRepositorio;

	    public OtrosService(OtrosRepository otrosRepositorio) {
	        this.otrosRepositorio = otrosRepositorio;
	    }

	    public Otros getOtros(Long id) throws NotFoundException {
	        return otrosRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Otros createOtros(Otros otros) {
	        return otrosRepositorio.save(otros);
	    }
	    
	    public void deleteOtros(Otros otros) {
	    	otrosRepositorio.delete(otros);
	    }
	    
	    
	    public List<Otros> listarOtros(){
	    	return (List<Otros>)otrosRepositorio.findAll();
	    }
	    

		 public OtrosRepository getOtrosRepositorio() {
			return otrosRepositorio;
		}
}
