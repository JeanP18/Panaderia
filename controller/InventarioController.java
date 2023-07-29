package com.grupo3.sistemacomprapanaderia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.grupo3.sistemacomprapanaderia.entity.Inventario;
import com.grupo3.sistemacomprapanaderia.entity.Producto;

import com.grupo3.sistemacomprapanaderia.entity.Almacen;

import com.grupo3.sistemacomprapanaderia.service.impl.AlmacenServiceImpl;

import com.grupo3.sistemacomprapanaderia.service.impl.InventarioServiceImpl;
import com.grupo3.sistemacomprapanaderia.service.impl.ProductoServiceImpl;



@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {
	@Autowired
	private InventarioServiceImpl service;
	
	@Autowired
	private AlmacenServiceImpl serviceAlmacen;
	
	@Autowired
	private ProductoServiceImpl serviceProducto;
	
	    //localhost:8091/api/inventarios (GET)
		@GetMapping() 
		public ResponseEntity<List<Inventario>> getAll(){
			List<Inventario> inventarios= service.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(inventarios);
		}
		
		//localhost:8091/api/inventarios/1 (GET)
		@GetMapping(value="/{id}") 
		public ResponseEntity<Inventario> getById(@PathVariable("id") int id) {
			Inventario inventario = service.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(inventario);
		}
		
		//localhost:8091/api/inventarios (POST)
		@PostMapping 
		public ResponseEntity<Inventario> create(@RequestBody Inventario inventario) {
			Inventario inventarioDb=service.create(inventario);
			return ResponseEntity.status(HttpStatus.CREATED).body(inventarioDb);
		}
		
		//localhost:8091/api/inventarios/1 (PUT)
		@PutMapping
		public ResponseEntity<Inventario> update(@RequestBody Inventario inventario) {
			Inventario inventarioDb=service.update(inventario);
			return ResponseEntity.status(HttpStatus.OK).body(inventarioDb);
		}
		
		//localhost:8091/api/inventarios/1 (DELETE)
		@DeleteMapping(value="/{id}")
		public int delete(@PathVariable("id") int id){
			return service.delete(id);
		}
		
		//localhost:8091/api/inventarios/selectAlmacen (get)
		@GetMapping(value="/selectAlmacenes")
		public ResponseEntity<List<Almacen>> selectAlmacenes(){
			List<Almacen> almacenes= serviceAlmacen.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(almacenes);
		}
		
		//localhost:8091/api/compras/selectProveedor (get)
		@GetMapping(value="/selectProductos")
		public ResponseEntity<List<Producto>> selectProductoss(){
			List<Producto> productos= serviceProducto.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(productos);
		}
}
