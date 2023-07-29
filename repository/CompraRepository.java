package com.grupo3.sistemacomprapanaderia.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo3.sistemacomprapanaderia.entity.Compra;


public interface CompraRepository extends JpaRepository<Compra, Integer> {
	List<Compra> findByNombreContaining(String texto);
	Compra findByNombre(String texto);
	
	
}
