package com.grupo3.sistemacomprapanaderia.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.sistemacomprapanaderia.entity.Compra;
import com.grupo3.sistemacomprapanaderia.entity.Gerente;
import com.grupo3.sistemacomprapanaderia.entity.Proveedor;
import com.grupo3.sistemacomprapanaderia.repository.CompraRepository;
import com.grupo3.sistemacomprapanaderia.repository.GerenteRepository;
import com.grupo3.sistemacomprapanaderia.repository.ProveedorRepository;
import com.grupo3.sistemacomprapanaderia.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {
	@Autowired
	private CompraRepository repository;
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Compra> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Compra findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Compra findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compra> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Compra create(Compra obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Compra update(Compra obj) {
		try {
			Compra compraDb=repository.findById(obj.getId()).orElse(null);
			if(compraDb==null) {
				return null;
			}
			compraDb.setNombre(obj.getNombre());
			compraDb.setFecha(obj.getFecha());
			compraDb.setCantidadSolicitada(obj.getCantidadSolicitada());
			return repository.save(compraDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Compra compraDb=repository.findById(id).orElse(null);
			if(compraDb==null) {
				return 0;
			}else {
				repository.delete(compraDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Gerente> selectGerente() {
		try {
			return gerenteRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> selectProveedor() {
		try {
			return proveedorRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}
