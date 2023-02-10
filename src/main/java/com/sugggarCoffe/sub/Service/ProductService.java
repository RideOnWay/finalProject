package com.sugggarCoffe.sub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sugggarCoffe.sub.Repository.ProductoRepository;
import com.sugggarCoffe.sub.model.Producto;

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
	    

		 public ProductoRepository getProductoRepositorio() {
			return productoRepositorio;
		}
		 
		
}
