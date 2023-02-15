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

import com.sugggarCoffe.sub.model.Insumo;
import com.sugggarCoffe.sub.model.Proveedor;
import com.sugggarCoffe.sub.service.InsumoService;
import com.sugggarCoffe.sub.service.ProveedorService;

@Controller
public class InsumoController {

	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	
	
	@GetMapping("/listInsumo")
	public String getAllInsumo(Model model) {
		
		List<Proveedor> listProveedor =proveedorService.listarProveedor(); 
		List<Insumo> listInsumo  =insumoService.listarInsumo();
		
			
		try {
		      model.addAttribute("listInsumo", listInsumo);
		      model.addAttribute("listProveedor", listProveedor);
		      
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		      System.out.println("se cayo sta cosa"); 
		    }
		return "inventario/listInsumo";
	}
	
	@PostMapping("/listInsumo")
	public String newInsumo(@ModelAttribute Insumo insumo) {
		insumoService.createInsumo(insumo);
		return "redirect:/listInsumo";
	}
	
	@GetMapping("/insumo/{id}/delete")
	public String borrarInsumo(@PathVariable long id ) throws NotFoundException {
		System.out.println(id);
		Insumo insumo = insumoService.getInsumo(id);
		insumoService.deleteInsumo(insumo);
		return "redirect:/listInsumo";
	}
	
	 @GetMapping("/insumo/{id}/edit")
	  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
	      model.addAttribute("insumo", insumoService.getInsumo(id));
	      return "inventario/listInsumo";
	  }
	
	  @PostMapping("/insumo/{id}/edit")
	  public String edit(Insumo insumo) {
	  	insumoService.createInsumo(insumo);
	      return "redirect:/listInsumo";
	  }
}
