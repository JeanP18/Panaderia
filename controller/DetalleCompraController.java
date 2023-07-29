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

import com.grupo3.sistemacomprapanaderia.entity.Producto;
import com.grupo3.sistemacomprapanaderia.entity.Compra;
import com.grupo3.sistemacomprapanaderia.entity.DetalleCompra;
import com.grupo3.sistemacomprapanaderia.service.impl.CompraServiceImpl;
import com.grupo3.sistemacomprapanaderia.service.impl.DetalleCompraServiceImpl;
import com.grupo3.sistemacomprapanaderia.service.impl.ProductoServiceImpl;



@RestController
@RequestMapping("/api/detallecompras")
public class DetalleCompraController {
	@Autowired
	private DetalleCompraServiceImpl service;
	
	@Autowired
	private CompraServiceImpl serviceCompra;
	
	@Autowired
	private ProductoServiceImpl serviceProducto;
	
	    //localhost:8091/api/detallecompras (GET)
		@GetMapping() 
		public ResponseEntity<List<DetalleCompra>> getAll(){
			List<DetalleCompra> detallecompras= service.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(detallecompras);
		}
		
		//localhost:8091/api/detallecompras/1 (GET)
		@GetMapping(value="/{id}") 
		public ResponseEntity<DetalleCompra> getById(@PathVariable("id") int id) {
			DetalleCompra detallecompra = service.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(detallecompra);
		}
		
		//localhost:8091/api/detallecompras (POST)
		@PostMapping 
		public ResponseEntity<DetalleCompra> create(@RequestBody DetalleCompra detallecompra) {
			DetalleCompra detallecompraDb=service.create(detallecompra);
			return ResponseEntity.status(HttpStatus.CREATED).body(detallecompraDb);
		}
		
		//localhost:8091/api/detallecompras/1 (PUT)
		@PutMapping
		public ResponseEntity<DetalleCompra> update(@RequestBody DetalleCompra detallecompra) {
			DetalleCompra detallecompraDb=service.update(detallecompra);
			return ResponseEntity.status(HttpStatus.OK).body(detallecompraDb);
		}
		
		//localhost:8091/api/detallecompras/1 (DELETE)
		@DeleteMapping(value="/{id}")
		public int delete(@PathVariable("id") int id){
			return service.delete(id);
		}
		
		//localhost:8091/api/detallecompras/selectCompras (get)
		@GetMapping(value="/selectCompras")
		public ResponseEntity<List<Compra>> selectCompras(){
			List<Compra> compras= serviceCompra.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(compras);
		}
		
		//localhost:8091/api/detallecompras/selectProducto (get)
		@GetMapping(value="/selectProductos")
		public ResponseEntity<List<Producto>> selectProductos(){
			List<Producto> productos= serviceProducto.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(productos);
		}
}
