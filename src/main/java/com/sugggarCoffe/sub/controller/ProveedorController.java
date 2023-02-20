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

import com.sugggarCoffe.sub.model.Proveedor;
import com.sugggarCoffe.sub.service.ProveedorService;

@Controller
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;

	@GetMapping("/listProveedor")
	public String getAllProveedor(Model model) {
		List<Proveedor> listProveedor  =proveedorService.listarProveedor();
		try {
		      model.addAttribute("listProveedor", listProveedor);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		      System.out.println("se cayo sta cosa"); 
		    }
		return "inventario/listProveedor";
	}
	
	@PostMapping("/listProveedor")
	public String newProveedor(@ModelAttribute Proveedor proveedor) {
		proveedorService.createProveedor(proveedor);
		return "redirect:/listProveedor";
	}
	
	@GetMapping("/proveedor/{id}/delete")
	public String borrarProveedor(@PathVariable long id ) throws NotFoundException {
		System.out.println(id);
		Proveedor proveedor = proveedorService.getProveedor(id);
		proveedorService.deleteProveedor(proveedor);
		return "redirect:/listProveedor";
	}

}









