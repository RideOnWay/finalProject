package com.sugggarCoffe.sub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sugggarCoffe.sub.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/index")
	public String toIndex(Model model) {
		String rolUsuario =usuarioService.getCurrentRolUsuario();
		
		model.addAttribute("rolUsuario", rolUsuario);
		return "index";
	}
	
	@GetMapping("/gestionInventario")
	public String toInventario() {
		String rolUsuario =usuarioService.getCurrentRolUsuario();
		if(rolUsuario != null && rolUsuario.equalsIgnoreCase("ADMIN")) {
			return "inventario/gestionInventario";
		}else {
			return "/index";
		}
		
	}
	
	@GetMapping("/cajeroGestion")
	public String toCajeroGestion() {
		String rolUsuario =usuarioService.getCurrentRolUsuario();
		if(rolUsuario != null && rolUsuario.equalsIgnoreCase("CAJERO")) {
			return "inventario/cajeroGestion";
		}else {
			return "/index";
		}	
	}
	
	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}

	@GetMapping("/listReporte")
	public String listReportes() {
		return "inventario/listReporte";
	}
	
	@GetMapping("/listDevolucione")
	public String listDevoluciones() {
		return "inventario/listDevolucione";
	}
	
	@GetMapping("/listOtros")
	public String listOtro() {
		return "inventario/listOtros";
	}
	
	@GetMapping("/closeSession")
	public String closeSession(HttpSession session) {
		session.invalidate();
		return "index";
	}
	

	
	

}
