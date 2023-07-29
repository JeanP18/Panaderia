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

import com.grupo3.sistemacomprapanaderia.entity.Proveedor;
import com.grupo3.sistemacomprapanaderia.service.impl.ProveedorServiceImpl;


@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
	@Autowired
	private ProveedorServiceImpl service;
	
	@GetMapping() //localhost:8091/api/proveedore (get)
	public ResponseEntity<List<Proveedor>> getAll(){
		List<Proveedor> proveedores = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(proveedores);
	}
	
	@GetMapping(value = "/{id}")//localhost:8091/api/proveedore/1 (get)
	public ResponseEntity<Proveedor> getById(@PathVariable("id") int id){
		Proveedor proveedor = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(proveedor);
	}
	
	@PostMapping //localhost:8091/api/proveedore (POST)
	public ResponseEntity<Proveedor> create(@RequestBody Proveedor proveedor){
		Proveedor proveedorDb = service.create(proveedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorDb);
	}
	
	@PutMapping //localhost:8091/api/proveedore/1 (PUT)
	public ResponseEntity<Proveedor> update(@RequestBody Proveedor proveedor){
		Proveedor proveedorDb = service.update(proveedor);
		return ResponseEntity.status(HttpStatus.OK).body(proveedorDb);
	}
	
	@DeleteMapping (value = "/{id}")//localhost:8091/api/proveedore/1 (DELETE)
	public int DELETE (@PathVariable ("id")int id) {
		return service.delete(id);
	}

}
