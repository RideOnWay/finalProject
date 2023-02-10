package com.sugggarCoffe.sub.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/gestionInventario")
	public String toInventario() {
		return "inventario/gestionInventario";
	}
	
	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}
	
	@GetMapping("/ventas")
	public String toVentas() {
		return "ventas/ventas";
	}
	
//	@GetMapping("/listInsumo")
//	public String listInsumos() {
//		return "inventario/listInsumo";
//	}
//	
//	@GetMapping("/listInventariod")
//	public String listInventariod() {
//		return "inventario/listInventariod";
//	}
//	
//	@GetMapping("/listReporte")
//	public String listReportes() {
//		return "inventario/listReporte";
//	}
//	
////	@GetMapping("/listUsuario")
////	public String listUsuarios() {
////		return "inventario/listUsuario";
////	}
//	
//	@GetMapping("/listCliente")
//	public String listClientes() {
//		return "inventario/listCliente";
//	}
//	
//	@GetMapping("/listDevolucione")
//	public String listDevoluciones() {
//		return "inventario/listDevolucione";
//	}
//	
//	@GetMapping("/listOtros")
//	public String listOtro() {
//		return "inventario/listOtros";
//	}
	

	
	

}
