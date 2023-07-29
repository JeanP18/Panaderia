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

import com.grupo3.sistemacomprapanaderia.entity.Gerente;
import com.grupo3.sistemacomprapanaderia.entity.Proveedor;
import com.grupo3.sistemacomprapanaderia.entity.Compra;
import com.grupo3.sistemacomprapanaderia.service.impl.CompraServiceImpl;
import com.grupo3.sistemacomprapanaderia.service.impl.GerenteServiceImpl;
import com.grupo3.sistemacomprapanaderia.service.impl.ProveedorServiceImpl;


@RestController
@RequestMapping("/api/compras")
public class CompraController {
	@Autowired
	private CompraServiceImpl service;
	
	@Autowired
	private GerenteServiceImpl serviceGerente;
	
	@Autowired
	private ProveedorServiceImpl serviceProveedor;
	
	    //localhost:8091/api/compras (GET)
		@GetMapping() 
		public ResponseEntity<List<Compra>> getAll(){
			List<Compra> compras= service.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(compras);
		}
		
		//localhost:8091/api/compras/1 (GET)
		@GetMapping(value="/{id}") 
		public ResponseEntity<Compra> getById(@PathVariable("id") int id) {
			Compra compra = service.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(compra);
		}
		
		//localhost:8091/api/compras (POST)
		@PostMapping 
		public ResponseEntity<Compra> create(@RequestBody Compra compra) {
			Compra compraDb=service.create(compra);
			return ResponseEntity.status(HttpStatus.CREATED).body(compraDb);
		}
		
		//localhost:8091/api/compras/1 (PUT)
		@PutMapping
		public ResponseEntity<Compra> update(@RequestBody Compra compra) {
			Compra compraDb=service.update(compra);
			return ResponseEntity.status(HttpStatus.OK).body(compraDb);
		}
		
		//localhost:8091/api/compras/1 (DELETE)
		@DeleteMapping(value="/{id}")
		public int delete(@PathVariable("id") int id){
			return service.delete(id);
		}
		
		//localhost:8091/api/compras/selectGerente (get)
		@GetMapping(value="/selectGerentes")
		public ResponseEntity<List<Gerente>> selectGerentes(){
			List<Gerente> gerentes= serviceGerente.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(gerentes);
		}
		
		//localhost:8091/api/compras/selectProveedor (get)
		@GetMapping(value="/selectProveedores")
		public ResponseEntity<List<Proveedor>> selectProveedores(){
			List<Proveedor> proveedores= serviceProveedor.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(proveedores);
		}
}
