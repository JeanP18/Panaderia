package com.grupo3.sistemacomprapanaderia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.grupo3.sistemacomprapanaderia.entity.Almacen;


public interface AlmacenRepository  extends JpaRepository<Almacen, Integer> {
	
	List<Almacen> findByNombreContaining(String texto);
	Almacen findByNombre(String texto);
	
}
