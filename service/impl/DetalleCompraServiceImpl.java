package com.grupo3.sistemacomprapanaderia.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.sistemacomprapanaderia.entity.Compra;
import com.grupo3.sistemacomprapanaderia.entity.DetalleCompra;
import com.grupo3.sistemacomprapanaderia.entity.Producto;
import com.grupo3.sistemacomprapanaderia.repository.CompraRepository;
import com.grupo3.sistemacomprapanaderia.repository.DetalleCompraRepository;
import com.grupo3.sistemacomprapanaderia.repository.ProductoRepository;
import com.grupo3.sistemacomprapanaderia.service.DetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {
	@Autowired
	private DetalleCompraRepository repository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleCompra> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleCompra findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleCompra findByCantidadComprada(int cantidadComprada) {
		try {
			return repository.findByCantidadComprada(cantidadComprada);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleCompra> findByCantidadCompradaContaining(int cantidadComprada) {
		try {
			return repository.findByCantidadCompradaContaining(cantidadComprada);
		} catch (Exception e) {
			return null;
		}
	
	}

	@Override
	@Transactional
	public DetalleCompra create(DetalleCompra obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public DetalleCompra update(DetalleCompra obj) {
		try {
			DetalleCompra detallecompraDb=repository.findById(obj.getId()).orElse(null);
			if(detallecompraDb==null) {
				return null;
			}
			detallecompraDb.setCompra(obj.getCompra());
			detallecompraDb.setProducto(obj.getProducto());
			detallecompraDb.setCantidadComprada(obj.getCantidadComprada());
			detallecompraDb.setPrecioUnitario(obj.getPrecioUnitario());
			detallecompraDb.setSubTotal(obj.getSubTotal());
			return repository.save(detallecompraDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			DetalleCompra detallecompraDb=repository.findById(id).orElse(null);
			if(detallecompraDb==null) {
				return 0;
			}else {
				repository.delete(detallecompraDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compra> selectCompra() {
		try {
			return compraRepository.findAll();
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
	
