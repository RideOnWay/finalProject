package com.sugggarCoffe.sub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.model.Producto;
import com.sugggarCoffe.sub.model.Usuario;
import com.sugggarCoffe.sub.repository.ProductoRepository;

@Service
public class ProductService {
	
	@Autowired
	private final ProductoRepository productoRepositorio;

	    public ProductService(ProductoRepository productoRepositorio) {
	        this.productoRepositorio = productoRepositorio;
	    }

	    public Producto getProducto(Long id) throws NotFoundException {
	        return productoRepositorio.findById(id).orElseThrow(NotFoundException::new);
	    }

	    public Producto createProducto(Producto producto) {
	        return productoRepositorio.save(producto);
	    }
	    
	    public void deleteProducto(Producto producto) {
	         productoRepositorio.delete(producto);
	    }
	    
	    
	    public List<Producto> listarProducto(){
	    	return (List<Producto>)productoRepositorio.findAll();
	    }
	    
	    public List<Producto> listarProductoxTipo(String tipo){
	    	List<Producto> todo =(List<Producto>)productoRepositorio.findAll();
	    	List<Producto> drink = new ArrayList<Producto>();
	    	for(Producto bebida:todo) {
	    		if(bebida.getTipo().equalsIgnoreCase(tipo)) {
	    			drink.add(bebida);
	    		}
	    	}	
	    	return drink;
	    }
	    

		 public ProductoRepository getProductoRepositorio() {
			return productoRepositorio;
		}
		 
		
}
