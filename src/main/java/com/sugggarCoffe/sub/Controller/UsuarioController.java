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

import com.sugggarCoffe.sub.Service.UsuarioService;
import com.sugggarCoffe.sub.model.Usuario;

@Controller
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/listUsuario")
	public String newUsuario(@ModelAttribute Usuario usuario) {
		usuarioService.createUsuario(usuario);
		return "redirect:/listUsuario";
	}
	
	@GetMapping("/listUsuario")
	public String getAllUsuario(Model model) {
		List<Usuario> listUsuario  =usuarioService.listarUsuario();
		try {
		      model.addAttribute("listUsuario", listUsuario);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		      System.out.println("se cayo sta cosa"); 
		    }
		return "inventario/listUsuario";
	}
	
	@GetMapping("/usuario/{id}/delete")
	public String borrarUsuario(@PathVariable long id ) throws NotFoundException {
		System.out.println(id);
		Usuario usuario = usuarioService.getUsuario(id);
		usuarioService.deleteUsuario(usuario);
		return "redirect:/listUsuario";
	}
	
	 @GetMapping("/usuario/{id}/edit")
	  public String edit(@PathVariable Long id, Model model) throws NotFoundException {
	      model.addAttribute("usuario", usuarioService.getUsuario(id));
	      return "inventario/listUsuario";
	  }
	
	  @PostMapping("/usuario/{id}/edit")
	  public String edit(Usuario usuario) {
	  	usuarioService.createUsuario(usuario);
	      return "redirect:/listUsuario";
	  }
}
