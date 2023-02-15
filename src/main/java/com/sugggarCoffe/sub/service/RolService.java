package com.sugggarCoffe.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.model.Rol;
import com.sugggarCoffe.sub.repository.RolRepository;



@Service
public class RolService {

	@Autowired
	private final RolRepository rolRepositorio;


	    public Rol getRol(Long id) throws NotFoundException {
	        return rolRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Rol createRol(Rol rol) {
	        return rolRepositorio.save(rol);
	    }
	    
	    public void deleteRol(Rol rol) {
	    	rolRepositorio.delete(rol);
	    }
	    
	    
	    public List<Rol> listarRol(){
	    	return (List<Rol>)rolRepositorio.findAll();
	    }

		public RolService(RolRepository rolRepositorio) {
			this.rolRepositorio = rolRepositorio;
		}

		public RolRepository getRolRepositorio() {
			return rolRepositorio;
		}
}
