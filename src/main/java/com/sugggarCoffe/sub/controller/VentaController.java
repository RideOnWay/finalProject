package com.sugggarCoffe.sub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sugggarCoffe.sub.model.Producto;
import com.sugggarCoffe.sub.model.Venta;
import com.sugggarCoffe.sub.service.ProductService;
import com.sugggarCoffe.sub.service.VentaService;

@Controller
public class VentaController {
	

	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private ProductService productoService; 

	@PostMapping("/listVenta")
	public String newVenta(@ModelAttribute Venta venta) {
		ventaService.createVenta(venta);
		return "redirect:/listVenta";
	}
	
	@GetMapping("/venta")
	public String getAllVenta(Model model) {
		List<Venta> listVenta  =ventaService.listarVenta();
		List<Producto> listProdrink  =productoService.listarProductoxTipo("Bebida");
		List<Producto> listProsnack  =productoService.listarProductoxTipo("snack");
		try {
		      model.addAttribute("listVenta", listVenta);
		      model.addAttribute("listProdrink", listProdrink);
		      model.addAttribute("listProsnack", listProsnack);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		     
		    }
		return "venta/venta";
	}
	
	@GetMapping("/venta/{id}/delete")
	public String borrarVenta(@PathVariable long id ) throws NotFoundException {
		System.out.println(id);
		Venta venta = ventaService.getVenta(id);
		ventaService.deleteVenta(venta);
		return "redirect:/listVenta";
	}
	
	 @GetMapping("/venta/{id}/edit")
	  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
	      model.addAttribute("venta", ventaService.getVenta(id));
	      return "inventario/listVenta";
	  }
	
	  @PostMapping("/venta/{id}/edit")
	  public String edit(Venta venta) {
	  	ventaService.createVenta(venta);
	      return "redirect:/listVenta";
	  }

}
