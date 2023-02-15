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

import com.sugggarCoffe.sub.model.Rol;
import com.sugggarCoffe.sub.model.Usuario;
import com.sugggarCoffe.sub.service.RolService;
import com.sugggarCoffe.sub.service.UsuarioService;

@Controller
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;

	@PostMapping("/listUsuario")
	public String newUsuario(@ModelAttribute Usuario usuario) {
		usuarioService.createUsuario(usuario);
		return "redirect:/listUsuario";
	}
	
	@GetMapping("/listUsuario")
	public String getAllUsuario(Model model) {
		List<Usuario> listUsuario  =usuarioService.listarUsuario();
		List<Rol> listRol =rolService.listarRol();
		try {
		      model.addAttribute("listUsuario", listUsuario);
		      model.addAttribute("listRol", listRol);
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
