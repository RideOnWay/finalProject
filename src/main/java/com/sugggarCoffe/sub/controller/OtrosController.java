package com.sugggarCoffe.sub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sugggarCoffe.sub.model.Proveedor;
import com.sugggarCoffe.sub.service.ProveedorService;

@Controller
public class OtrosController {

	@Autowired
	private ProveedorService proveedorService;

//	@GetMapping("/listOtros")
//	public String getAllProveedor(Model model) {
//		List<Proveedor> listProveedor =proveedorService.listarProveedor();
//		      model.addAttribute("listProveedor", listProveedor);
//		return "inventario/listOtros";
//	}
}
