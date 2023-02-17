package com.sugggarCoffe.sub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sugggarCoffe.sub.model.Usuario;
import com.sugggarCoffe.sub.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	 @Autowired
	  private UsuarioService usuarioService;

	 @GetMapping("/log")
	  public String usuarioForm(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    return "login";
	  }

	  @PostMapping("/log")
	  public String usuarioSubmit(@ModelAttribute Usuario usuario,HttpSession session) {
		  Usuario foundUser = usuarioService.findByUsernameAndPassword(usuario.getCorreoUsuario(), usuario.getContrasenaUsuario());
	    if (foundUser != null) {	 
	    	session.setAttribute("usuarioNombre", foundUser.getNombreUsuario());
	    	session.setAttribute("idUsuario", foundUser.getIdUsuario());
	        if(foundUser.getRol().getRolName().equalsIgnoreCase("ADMIN")) {
	        	return "inventario/gestionInventario";
	        }else {
	        	return "redirect:/venta";
	        }	 
	    
	    } else {
	      
	      return "login";
	    }
	  }
	 
	 
	  
	  

	

	
}
