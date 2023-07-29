package com.grupo3.sistemacomprapanaderia.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.sistemacomprapanaderia.entity.Almacen;

import com.grupo3.sistemacomprapanaderia.entity.Inventario;
import com.grupo3.sistemacomprapanaderia.entity.Producto;

import com.grupo3.sistemacomprapanaderia.repository.AlmacenRepository;

import com.grupo3.sistemacomprapanaderia.repository.InventarioRepository;
import com.grupo3.sistemacomprapanaderia.repository.ProductoRepository;

import com.grupo3.sistemacomprapanaderia.service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService {
	@Autowired
	private InventarioRepository repository;
	
	@Autowired
	private AlmacenRepository almacenRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Inventario> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Inventario findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Inventario findByCantidadDisponible(int cantidadDisponible) {
		try {
			return repository.findByCantidadDisponible(cantidadDisponible);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Inventario> findByCantidadDisponibleContaining(int cantidadDisponible) {
		try {
			return repository.findByCantidadDisponibleContaining(cantidadDisponible);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Inventario create(Inventario obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Inventario update(Inventario obj) {
		try {
			Inventario inventarioDb=repository.findById(obj.getId()).orElse(null);
			if(inventarioDb==null) {
				return null;
			}
			inventarioDb.setCantidadDisponible(obj.getCantidadDisponible());
			inventarioDb.setAlmacen(obj.getAlmacen());
			inventarioDb.setProducto(obj.getProducto());
			return repository.save(inventarioDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Inventario inventarioDb=repository.findById(id).orElse(null);
			if(inventarioDb==null) {
				return 0;
			}else {
				repository.delete(inventarioDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Almacen> selectAlmacen() {
		try {
			return almacenRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> selectProducto() {
		try {
			return productoRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}
