package com.grupo3.sistemacomprapanaderia.service;

import java.util.List;

import com.grupo3.sistemacomprapanaderia.entity.Almacen;
import com.grupo3.sistemacomprapanaderia.entity.Producto;
import com.grupo3.sistemacomprapanaderia.entity.Inventario;

public interface InventarioService {
	public List<Inventario> findAll();
	public Inventario findById(int id);
	public Inventario findByCantidadDisponible(int cantidadDisponible);
	List<Inventario> findByCantidadDisponibleContaining(int cantidadDisponible);
	public Inventario create(Inventario obj);
	public Inventario update(Inventario obj);
	public int delete(int id);
	public List<Almacen> selectAlmacen();
	public List<Producto> selectProducto();
	
}
