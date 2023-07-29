package com.grupo3.sistemacomprapanaderia.service;

import java.util.List;

import com.grupo3.sistemacomprapanaderia.entity.Gerente;
import com.grupo3.sistemacomprapanaderia.entity.Proveedor;
import com.grupo3.sistemacomprapanaderia.entity.Compra;

public interface CompraService {
	public List<Compra> findAll();
	public Compra findById(int id);
	public Compra findByNombre(String nombre);
	public List<Compra> findByNombreContaining(String nombre);
	public Compra create(Compra obj);
	public Compra update(Compra obj);
	public int delete(int id);
	public List<Gerente> selectGerente();
	public List<Proveedor> selectProveedor();
}
