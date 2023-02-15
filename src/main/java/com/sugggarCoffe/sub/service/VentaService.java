package com.sugggarCoffe.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.model.Venta;
import com.sugggarCoffe.sub.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	private final VentaRepository ventaRepositorio;


	    public Venta getVenta(Long id) throws NotFoundException {
	        return ventaRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Venta createVenta(Venta venta) {
	        return ventaRepositorio.save(venta);
	    }
	    
	    public void deleteVenta(Venta venta) {
	    	ventaRepositorio.delete(venta);
	    }
	    
	    
	    public List<Venta> listarVenta(){
	    	return (List<Venta>)ventaRepositorio.findAll();
	    }

		public VentaService(VentaRepository ventaRepositorio) {
			this.ventaRepositorio = ventaRepositorio;
		}

		public VentaRepository getVentaRepositorio() {
			return ventaRepositorio;
		}
}
