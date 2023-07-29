package com.grupo3.sistemacomprapanaderia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.grupo3.sistemacomprapanaderia.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	List<Categoria> findByNombreContaining(String texto);
	Categoria findByNombre(String texto);
}
