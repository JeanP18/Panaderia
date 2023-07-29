package com.grupo3.sistemacomprapanaderia.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;



@Controller
public class MainController {
	@GetMapping("/gerentes")
	public String getGerentes(Model model) {
		return "gerentes";
	}
	
	@GetMapping("/proveedores")
	public String getProveedores(Model model) {
		return "proveedores";
	}
	
	@GetMapping("/categorias")
	public String getCategorias(Model model) {
		return "categorias";
	}
	@GetMapping("/productos")
	public String getProductos(Model model) {
		return "productos";
	}
	
	@GetMapping("/almacenes")
	public String getAlmacenes(Model model) {
		return "almacenes";
	}
	
	@GetMapping("/compras")
	public String getCompras(Model model) {
		return "compras";
	}
	
	@GetMapping("/detalleCompras")
	public String getDetalleCompras(Model model) {
		return "detalleCompras";
	}
	
	@GetMapping("/inventarios")
	public String getInventarios(Model model) {
		return "inventarios";
	}

}
