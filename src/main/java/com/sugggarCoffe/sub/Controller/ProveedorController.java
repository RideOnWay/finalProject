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

import com.sugggarCoffe.sub.Service.ProveedorService;
import com.sugggarCoffe.sub.model.Proveedor;

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
	
	 @GetMapping("/proveedor/{id}/edit")
	  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
	      model.addAttribute("proveedor", proveedorService.getProveedor(id));
	      return "inventario/listProveedor";
	  }
	
	  @PostMapping("/proveedor/{id}/edit")
	  public String edit(Proveedor proveedor) {
	  	proveedorService.createProveedor(proveedor);
	      return "redirect:/listProveedor";
	  }



}










//@PostMapping("/listProveedor")
//public String create(Proveedor proveedor) {
//	proveedorService.createProveedor(proveedor);
//  return "redirect: inventario/proveedorDetalle";
//}
//
//
//@GetMapping("/listProveedor")
//  public String list(Model model) {
//      model.addAttribute("proveedor", proveedorService.listarProveedor());
//      return "inventario/proveedorDetalle";
//  }
//
//  @GetMapping("/proveedor/create")
//  public String create(Model model) {
//      model.addAttribute("product", new Proveedor());
//      return "inventario/proveedorDetalle";
//  }
//
//  
//
//  @GetMapping("/proveedor/{id}/edit")
//  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
//      model.addAttribute("proveedor", proveedorService.getProveedor(id));
//      return "inventario/proveedorDetalle";
//  }
//
//  @PostMapping("/proveedor/{id}/edit")
//  public String edit(Proveedor proveedor) {
//  	proveedorService.createProveedor(proveedor);
//      return "redirect:/inventario/proveedorDetalle*";
//  }

//@PostMapping("/proveedor/{id}/edit")
//public String edit(Proveedor proveedor) {
//	proveedorService.createProveedor(proveedor);
//  return "redirect:/inventario/proveedorDetalle*";
//}
  
 
  
//  @GetMapping("/proveedor/{id}/edit")
//  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
//      model.addAttribute("proveedor", proveedorService.getProveedor(id));
//      return "inventario/proveedorDetalle";
//  }
//

//
