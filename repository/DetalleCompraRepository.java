package com.grupo3.sistemacomprapanaderia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.grupo3.sistemacomprapanaderia.entity.DetalleCompra;


public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {
	List<DetalleCompra> findByCantidadCompradaContaining(int cantidadComprada);
	DetalleCompra findByCantidadComprada(int  cantidadComprada);
}
