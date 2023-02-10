package com.sugggarCoffe.sub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.Repository.ProveedorRepository;
import com.sugggarCoffe.sub.model.Proveedor;

@Service
public class ProveedorService {

	@Autowired
	private final ProveedorRepository proveedorRepository;

	    public ProveedorService(ProveedorRepository proveedorRepository) {
	        this.proveedorRepository = proveedorRepository;
	    }

	    public Proveedor getProveedor(Long id) throws NotFoundException {
	        return proveedorRepository.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Proveedor createProveedor(Proveedor proveedor) {
	        return proveedorRepository.save(proveedor);
	    }
	    
	    public void deleteProveedor(Proveedor proveedor) {
	    	proveedorRepository.delete(proveedor);
	    }
	    
	    
	    public List<Proveedor> listarProveedor(){
	    	return (List<Proveedor>)proveedorRepository.findAll();
	    }
	    

		 public ProveedorRepository getProveedorRepositorio() {
			return proveedorRepository;
		}
}
