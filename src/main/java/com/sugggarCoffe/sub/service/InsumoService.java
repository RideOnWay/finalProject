package com.sugggarCoffe.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.model.Insumo;
import com.sugggarCoffe.sub.repository.InsumoRepository;

@Service
public class InsumoService {
	

	@Autowired
	private final InsumoRepository insumoRepositorio;

	    public InsumoService(InsumoRepository insumoRepositorio) {
	        this.insumoRepositorio = insumoRepositorio;
	    }

	    public Insumo getInsumo(Long id) throws NotFoundException {
	        return insumoRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Insumo createInsumo(Insumo insumo) {
	        return insumoRepositorio.save(insumo);
	    }
	    
	    public void deleteInsumo(Insumo insumo) {
	    	insumoRepositorio.delete(insumo);
	    }
	    
	    
	    public List<Insumo> listarInsumo(){
	    	return (List<Insumo>)insumoRepositorio.findAll();
	    }
	    

		 public InsumoRepository getInsumoRepositorio() {
			return insumoRepositorio;
		}
}
