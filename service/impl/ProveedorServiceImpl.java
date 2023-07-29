package com.grupo3.sistemacomprapanaderia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.sistemacomprapanaderia.entity.Proveedor;
import com.grupo3.sistemacomprapanaderia.repository.ProveedorRepository;
import com.grupo3.sistemacomprapanaderia.service.ProveedorService;


@Service
public class ProveedorServiceImpl implements ProveedorService {
	@Autowired
	private ProveedorRepository repository;

	@Override
    @Transactional(readOnly =true)
	public List<Proveedor> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public Proveedor findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {			
		}
		return null;
	}

	@Override
    @Transactional(readOnly =true)
	public Proveedor findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public List<Proveedor> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public Proveedor findByRuc(String ruc) {
		try {
			return repository.findByRuc(ruc);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public List<Proveedor> findByRucContaining(String ruc) {
		try {
			return repository.findByRucContaining(ruc);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public Proveedor findByTelefono(String telefono) {
		try {
			return repository.findByTelefono(telefono);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public List<Proveedor> findByTelefonoContaining(String telefono) {
		try {
			return repository.findByTelefonoContaining(telefono);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	@Transactional
	public Proveedor create(Proveedor obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	@Override
	@Transactional
	public Proveedor update(Proveedor obj) {
		try {
			Proveedor proveedorDb=repository.findById(obj.getId()).orElseGet(null);
			if (proveedorDb==null) {
				return null;	
			}
			proveedorDb.setNombre(obj.getNombre());
			proveedorDb.setRuc(obj.getRuc());
			proveedorDb.setTelefono(obj.getTelefono());
			
			return repository.save(proveedorDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Proveedor proveedorDb=repository.findById(id).orElse(null);
			if (proveedorDb==null) {
				return 0;
			}else {
				repository.delete(proveedorDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}

	}
	

}
