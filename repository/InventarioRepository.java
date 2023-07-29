package com.grupo3.sistemacomprapanaderia.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo3.sistemacomprapanaderia.entity.Inventario;



public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
	  List<Inventario> findByCantidadDisponibleContaining(int cantidadDisponible);
	  Inventario findByCantidadDisponible(int cantidadDisponible);


}
