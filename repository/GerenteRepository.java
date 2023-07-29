package com.grupo3.sistemacomprapanaderia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.grupo3.sistemacomprapanaderia.entity.Gerente;


public interface GerenteRepository  extends JpaRepository<Gerente, Integer> {
	
	List<Gerente> findByNombreContaining(String texto);
	Gerente findByNombre(String texto);
	List<Gerente> findByRucContaining(String texto);
	Gerente findByRuc(String texto);
	List<Gerente> findByDireccionContaining(String texto);
	Gerente findByDireccion(String texto);
	
}
