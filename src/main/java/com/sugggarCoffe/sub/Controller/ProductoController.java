package com.sugggarCoffe.sub.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sugggarCoffe.sub.Service.InsumoService;
import com.sugggarCoffe.sub.Service.ProductService;
import com.sugggarCoffe.sub.model.Insumo;
import com.sugggarCoffe.sub.model.Producto;


@Controller
public class ProductoController {

	@Autowired
	private ProductService productoService;
	
	@Autowired
	private InsumoService insumoService;

	@PostMapping("/listProducto")
	public String newProducto(@ModelAttribute Producto producto) {
		productoService.createProducto(producto);
		return "redirect:/listProducto";
	}
	
	@GetMapping("/listProducto")
	public String getAllProducto(Producto producto,Model model) {
		List<Producto> listProducto  =productoService.listarProducto();
		List<Insumo> listInsumo  =insumoService.listarInsumo();
	
		try {
		      model.addAttribute("listProducto", listProducto);
		      model.addAttribute("listInsumo", listInsumo);
		    
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		      System.out.println("se cayo sta cosa"); 
		    }
		return "inventario/listProducto";
	}
	
	@GetMapping("/producto/{id}/delete")
	public String borrarProducto(@PathVariable long id ) throws NotFoundException {
		System.out.println(id);
		Producto producto = productoService.getProducto(id);
		productoService.deleteProducto(producto);
		return "redirect:/listProducto";
	}
	
	 @GetMapping("/producto/{id}/edit")
	  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
	      model.addAttribute("producto", productoService.getProducto(id));
	      return "inventario/listProducto";
	  }
	
	  @PostMapping("/producto/{id}/edit")
	  public String edit(Producto producto) {
	  	productoService.createProducto(producto);
	      return "redirect:/listProducto";
	  }
}
