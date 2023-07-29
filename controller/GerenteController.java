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
import com.grupo3.sistemacomprapanaderia.service.impl.GerenteServiceImpl;


@RestController
@RequestMapping("/api/gerentes")
public class GerenteController {
	@Autowired
	private GerenteServiceImpl service;
	
	@GetMapping() //localhost:8091/api/gerentes (get)
	public ResponseEntity<List<Gerente>> getAll(){
		List<Gerente> gerentes = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(gerentes);
	}
	
	@GetMapping(value = "/{id}")//localhost:8091/api/gerentes/1 (get)
	public ResponseEntity<Gerente> getById(@PathVariable("id") int id){
		Gerente gerente = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(gerente);
	}
	
	@PostMapping //localhost:8091/api/gerentes (POST)
	public ResponseEntity<Gerente> create(@RequestBody Gerente gerente){
		Gerente gerenteDb = service.create(gerente);
		return ResponseEntity.status(HttpStatus.CREATED).body(gerenteDb);
	}
	
	@PutMapping //localhost:8091/api/gerentes/1 (PUT)
	public ResponseEntity<Gerente> update(@RequestBody Gerente gerente){
		Gerente gerenteDb = service.update(gerente);
		return ResponseEntity.status(HttpStatus.OK).body(gerenteDb);
	}
	
	@DeleteMapping (value = "/{id}")//localhost:8091/api/gerentes/1 (DELETE)
	public int DELETE (@PathVariable ("id")int id) {
		return service.delete(id);
	}

}
