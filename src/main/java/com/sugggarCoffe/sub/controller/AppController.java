package com.sugggarCoffe.sub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppController {
	
	@GetMapping("/index")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping("/gestionInventario")
	public String toInventario() {
		return "inventario/gestionInventario";
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
