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

import com.sugggarCoffe.sub.Service.ClienteService;
import com.sugggarCoffe.sub.model.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/listCliente")
	public String getAllCliente(Model model) {
		List<Cliente> listCliente  =clienteService.listarCliente();
		try {
		      model.addAttribute("listCliente", listCliente);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		      System.out.println("se cayo sta cosa"); 
		    }
		return "inventario/listCliente";
	}
	
	@PostMapping("/listCliente")
	public String newCliente(@ModelAttribute Cliente cliente) {
		clienteService.createCliente(cliente);
		return "redirect:/listCliente";
	}
	
	@GetMapping("/cliente/{id}/delete")
	public String borrarCliente(@PathVariable long id ) throws NotFoundException {
		System.out.println(id);
		Cliente cliente = clienteService.getCliente(id);
		clienteService.deleteCliente(cliente);
		return "redirect:/listCliente";
	}
	
	 @GetMapping("/cliente/{id}/edit")
	  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
	      model.addAttribute("cliente", clienteService.getCliente(id));
	      return "inventario/listCliente";
	  }
	
	  @PostMapping("/cliente/{id}/edit")
	  public String edit(Cliente cliente) {
	  	clienteService.createCliente(cliente);
	      return "redirect:/listCliente";
	  }
}
