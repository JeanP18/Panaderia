package com.grupo3.sistemacomprapanaderia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.sistemacomprapanaderia.entity.Categoria;
import com.grupo3.sistemacomprapanaderia.entity.Producto;
import com.grupo3.sistemacomprapanaderia.repository.CategoriaRepository;
import com.grupo3.sistemacomprapanaderia.repository.ProductoRepository;
import com.grupo3.sistemacomprapanaderia.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Producto create(Producto obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Producto update(Producto obj) {
		try {
			Producto productoDb=repository.findById(obj.getId()).orElse(null);
			if(productoDb==null) {
				return null;
			}
			productoDb.setNombre(obj.getNombre());
			productoDb.setPrecio(obj.getPrecio());
			productoDb.setDescripcion(obj.getDescripcion());
			productoDb.setCategoria(obj.getCategoria());
			return repository.save(productoDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Producto productoDb=repository.findById(id).orElse(null);
			if(productoDb==null) {
				return 0;
			}else {
				repository.delete(productoDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> selectCategoria() {
		try {
			return categoriaRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	
	
}
