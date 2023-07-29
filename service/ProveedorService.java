package com.grupo3.sistemacomprapanaderia.service;

import java.util.List;

import com.grupo3.sistemacomprapanaderia.entity.Proveedor;


public interface ProveedorService {
	public List<Proveedor>findAll();
	public Proveedor findById(int id);
	public Proveedor findByNombre(String nombre);
	public List<Proveedor>findByNombreContaining(String nombre);
	public Proveedor findByRuc(String ruc);
	public List<Proveedor>findByRucContaining(String ruc);
	public Proveedor findByTelefono(String telefono);
	public List<Proveedor>findByTelefonoContaining(String telefono);
	public Proveedor create (Proveedor obj);
	public Proveedor update(Proveedor obj);
	public int delete (int id);
	
	
	
}
