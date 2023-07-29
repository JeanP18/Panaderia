package com.grupo3.sistemacomprapanaderia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.sistemacomprapanaderia.entity.Almacen;
import com.grupo3.sistemacomprapanaderia.entity.DetalleCompra;
import com.grupo3.sistemacomprapanaderia.entity.Gerente;
import com.grupo3.sistemacomprapanaderia.repository.AlmacenRepository;
import com.grupo3.sistemacomprapanaderia.repository.DetalleCompraRepository;
import com.grupo3.sistemacomprapanaderia.repository.GerenteRepository;
import com.grupo3.sistemacomprapanaderia.service.AlmacenService;

@Service
public class AlmacenServiceImpl implements AlmacenService {
	@Autowired
	private AlmacenRepository repository;
	@Autowired
	private GerenteRepository gerenteRepository;
	@Autowired
	private DetalleCompraRepository detalleCompraRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Almacen> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Almacen findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Almacen findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Almacen> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Almacen create(Almacen obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Almacen update(Almacen obj) {
		try {
			Almacen almacenDb=repository.findById(obj.getId()).orElse(null);
			if(almacenDb==null) {
				return null;
			}
			almacenDb.setNombre(obj.getNombre());
			almacenDb.setDireccion(obj.getDireccion());
			return repository.save(almacenDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Almacen almacenDb=repository.findById(id).orElse(null);
			if(almacenDb==null) {
				return 0;
			}else {
				repository.delete(almacenDb);
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
	public List<DetalleCompra> selectDetalleCompra() {
		try {
			return detalleCompraRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
}
