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

import com.sugggarCoffe.sub.model.IDiario;
import com.sugggarCoffe.sub.model.Producto;
import com.sugggarCoffe.sub.service.IDiarioService;
import com.sugggarCoffe.sub.service.ProductService;
import com.sugggarCoffe.sub.service.UsuarioService;

@Controller
public class IDiarioController {

	@Autowired
	private ProductService productoService;
	
	@Autowired
	private IDiarioService iDiarioService;
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/listIDiario")
	public String newIDiario(@ModelAttribute IDiario iDiario) {
		iDiarioService.createIDiario(iDiario);
		return "redirect:/listIDiario";
	}
	
	@GetMapping("/listIDiario")
	public String getAllProducto(Model model) {
		List<Producto> listProducto  =productoService.listarProducto();
		Long idUsuario=usuarioService.getCurrentIdUsuario();
		try {
		      model.addAttribute("listProducto", listProducto);
		      model.addAttribute("idUsuario",idUsuario);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		     
		    }
		return "inventario/listIDiario";
	}
	
	@GetMapping("/IDiario/{id}/delete")
	public String borrarProducto(@PathVariable long id ) throws NotFoundException {
		Producto producto = productoService.getProducto(id);
		productoService.deleteProducto(producto);
		return "redirect:/listPr";
	}
	
	 @GetMapping("/IDiario/{id}/edit")
	  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
	      model.addAttribute("producto", productoService.getProducto(id));
	      return "inventario/listPro";
	  }
	
	  @PostMapping("/IDiario/{id}/edit")
	  public String edit(Producto producto) {
	  	productoService.createProducto(producto);
	      return "redirect:/listProdu";
	  }
}
