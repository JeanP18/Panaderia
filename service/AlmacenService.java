package com.grupo3.sistemacomprapanaderia.service;

import java.util.List;


import com.grupo3.sistemacomprapanaderia.entity.Almacen;
import com.grupo3.sistemacomprapanaderia.entity.DetalleCompra;
import com.grupo3.sistemacomprapanaderia.entity.Gerente;

public interface AlmacenService {
	public List<Almacen> findAll();
	public Almacen findById(int id);
	public Almacen findByNombre(String nombre);
	public List<Almacen> findByNombreContaining(String nombre);
	public Almacen create(Almacen obj);
	public Almacen update(Almacen obj);
	public int delete(int id);
	public List<Gerente> selectGerente();	
	public List<DetalleCompra> selectDetalleCompra();	
}
