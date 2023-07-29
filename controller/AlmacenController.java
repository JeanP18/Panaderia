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

import com.grupo3.sistemacomprapanaderia.entity.Almacen;
import com.grupo3.sistemacomprapanaderia.entity.DetalleCompra;
import com.grupo3.sistemacomprapanaderia.entity.Gerente;
import com.grupo3.sistemacomprapanaderia.service.impl.AlmacenServiceImpl;
import com.grupo3.sistemacomprapanaderia.service.impl.DetalleCompraServiceImpl;
import com.grupo3.sistemacomprapanaderia.service.impl.GerenteServiceImpl;



@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {
	@Autowired
	private AlmacenServiceImpl service;
	
	@Autowired
	private DetalleCompraServiceImpl serviceDetalleCompra;
	
	@Autowired
	private GerenteServiceImpl serviceGerente;
	
	
	@GetMapping() //localhost:8091/api/almacenes (get)
	public ResponseEntity<List<Almacen>> getAll(){
		List<Almacen> almacenes = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(almacenes);
	}
	
	@GetMapping(value = "/{id}")//localhost:8091/api/almacenes/1 (get)
	public ResponseEntity<Almacen> getById(@PathVariable("id") int id){
		Almacen almacen = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(almacen);
	}
	
	@PostMapping //localhost:8091/api/almacenes (POST)
	public ResponseEntity<Almacen> create(@RequestBody Almacen almacen){
		Almacen almacenDb = service.create(almacen);
		return ResponseEntity.status(HttpStatus.CREATED).body(almacenDb);
	}
	
	@PutMapping //localhost:8091/api/almacenes/1 (PUT)
	public ResponseEntity<Almacen> update(@RequestBody Almacen almacen){
		Almacen almacenDb = service.update(almacen);
		return ResponseEntity.status(HttpStatus.OK).body(almacenDb);
	}
	
	@DeleteMapping (value = "/{id}")//localhost:8091/api/almacenes/1 (DELETE)
	public int DELETE (@PathVariable ("id")int id) {
		return service.delete(id);
	}
	
	//localhost:8091/api/almacenes/selectGerente (get)
	@GetMapping(value="/selectGerentes")
	public ResponseEntity<List<Gerente>> selectGerentes(){
		List<Gerente> gerentes= serviceGerente.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(gerentes);
	}
	
	
	//localhost:8091/api/almacenes/selectDetalleCompra (get)
		@GetMapping(value="/selectDetalleCompras")
		public ResponseEntity<List<DetalleCompra>> selectDetalleCompras(){
			List<DetalleCompra> detalleCompras= serviceDetalleCompra.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(detalleCompras);
		}
			


}
