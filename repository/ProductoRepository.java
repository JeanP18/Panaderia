package com.grupo3.sistemacomprapanaderia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.grupo3.sistemacomprapanaderia.entity.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByNombreContaining(String texto);
	Producto findByNombre(String texto);
}
