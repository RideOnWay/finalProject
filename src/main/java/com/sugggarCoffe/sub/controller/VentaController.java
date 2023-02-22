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

import com.sugggarCoffe.sub.model.Cliente;
import com.sugggarCoffe.sub.model.Producto;
import com.sugggarCoffe.sub.model.Venta;
import com.sugggarCoffe.sub.service.ClienteService;
import com.sugggarCoffe.sub.service.ProductService;
import com.sugggarCoffe.sub.service.UsuarioService;
import com.sugggarCoffe.sub.service.VentaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VentaController {
	

	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private ProductService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/venta")
	public String newVenta(@ModelAttribute Venta venta) {
		ventaService.createVenta(venta);
		return "redirect:/venta";
	}
	
	@GetMapping("/venta")
	public String getAllVenta(Model model,HttpSession session) {
		
		List<Cliente> listCliente  =clienteService.listarCliente();
		List<Producto> listProdrink  =productoService.listarProductoxTipo("Bebida");
		List<Producto> listProsnack  =productoService.listarProductoxTipo("snack");
		String nombreUsuario =usuarioService.getCurrentUsername();
		Long idUsuario=usuarioService.getCurrentIdUsuario();
		try {
			  model.addAttribute("listCliente", listCliente);
		      model.addAttribute("listProdrink", listProdrink);
		      model.addAttribute("listProsnack", listProsnack);
		      model.addAttribute("nombreUsuario",nombreUsuario);
		      model.addAttribute("idUsuario",idUsuario);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());		     
		    }
		return "venta/venta";
	}
	
	@GetMapping("/listVenta")
	public String getAllUsuario(Model model) {
		List<Venta> listVenta =ventaService.listarVenta();
		List<Producto> listProducto  =productoService.listarProducto();
		try {
		      model.addAttribute("listVenta", listVenta);	
		      model.addAttribute("listProducto", listProducto);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage()); 
		    }
		return "venta/listVenta";
	}
	
	@GetMapping("/venta/{id}/delete")
	public String borrarVenta(@PathVariable long id ) throws NotFoundException {
		Venta venta = ventaService.getVenta(id);
		ventaService.deleteVenta(venta);
		return "redirect:/listVenta";
	}
	

}
