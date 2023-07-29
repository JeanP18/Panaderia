package com.grupo3.sistemacomprapanaderia.service;

import java.util.List;

import com.grupo3.sistemacomprapanaderia.entity.Gerente;


public interface GerenteService {
	public List<Gerente>findAll();
	public Gerente findById(int id);
	public Gerente findByNombre(String nombre);
	public List<Gerente>findByNombreContaining(String nombre);
	public Gerente findByRuc(String ruc);
	public List<Gerente>findByRucContaining(String ruc);
	public Gerente findByDireccion(String direccion);
	public List<Gerente>findByDireccionContaining(String direccion);
	public Gerente create (Gerente obj);
	public Gerente update(Gerente obj);
	public int delete (int id);
	
	
	
}
