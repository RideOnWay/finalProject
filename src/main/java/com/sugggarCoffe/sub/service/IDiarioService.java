package com.sugggarCoffe.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.model.IDiario;
import com.sugggarCoffe.sub.repository.IDiarioRepository;

@Service
public class IDiarioService {

	@Autowired
	private final IDiarioRepository iDiarioRepositorio;

	    public IDiarioService(IDiarioRepository iDiarioRepositorio) {
	        this.iDiarioRepositorio = iDiarioRepositorio;
	    }

	    public IDiario getIDiario(Long id) throws NotFoundException {
	        return iDiarioRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public IDiario createIDiario(IDiario iDiario) {
	        return iDiarioRepositorio.save(iDiario);
	    }
	    
	    public void deleteIDiario(IDiario iDiario) {
	         iDiarioRepositorio.delete(iDiario);
	    }
	    
	    
	    public List<IDiario> listarIDiario(){
	    	return (List<IDiario>)iDiarioRepositorio.findAll();
	    }
	    
		 public IDiarioRepository getIDiarioRepositorio() {
			return iDiarioRepositorio;
		}
}
