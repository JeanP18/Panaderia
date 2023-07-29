package com.grupo3.sistemacomprapanaderia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo3.sistemacomprapanaderia.entity.Proveedor;


public interface ProveedorRepository  extends JpaRepository<Proveedor, Integer> {
	
	List<Proveedor> findByNombreContaining(String texto);
	Proveedor findByNombre(String texto);
	List<Proveedor> findByRucContaining(String texto);
	Proveedor findByRuc(String texto);
	List<Proveedor> findByTelefonoContaining(String texto);
	Proveedor findByTelefono(String texto);

	
}
