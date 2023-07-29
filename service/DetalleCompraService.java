package com.grupo3.sistemacomprapanaderia.service;

import java.util.List;

import com.grupo3.sistemacomprapanaderia.entity.Compra;
import com.grupo3.sistemacomprapanaderia.entity.Producto;
import com.grupo3.sistemacomprapanaderia.entity.DetalleCompra;

public interface DetalleCompraService {
	public List<DetalleCompra> findAll();
	public DetalleCompra findById(int id);
	public DetalleCompra findByCantidadComprada(int cantidadComprada);
	public List<DetalleCompra> findByCantidadCompradaContaining(int cantidadComprada);
	public DetalleCompra create(DetalleCompra obj);
	public DetalleCompra update(DetalleCompra obj);
	public int delete(int id);
	public List<Compra> selectCompra();
	public List<Producto> selectProducto();
}
