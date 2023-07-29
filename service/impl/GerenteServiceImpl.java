package com.grupo3.sistemacomprapanaderia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo3.sistemacomprapanaderia.entity.Gerente;
import com.grupo3.sistemacomprapanaderia.repository.GerenteRepository;
import com.grupo3.sistemacomprapanaderia.service.GerenteService;


@Service
public class GerenteServiceImpl implements GerenteService {
	@Autowired
	private GerenteRepository repository;

	@Override
    @Transactional(readOnly =true)
	public List<Gerente> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public Gerente findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {			
		}
		return null;
	}

	@Override
    @Transactional(readOnly =true)
	public Gerente findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public List<Gerente> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public Gerente findByRuc(String ruc) {
		try {
			return repository.findByRuc(ruc);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public List<Gerente> findByRucContaining(String ruc) {
		try {
			return repository.findByRucContaining(ruc);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    @Transactional(readOnly =true)
	public Gerente findByDireccion(String direccion) {
		try {
			return repository.findByDireccion(direccion);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
    @Transactional(readOnly =true)
	public List<Gerente> findByDireccionContaining(String direccion) {
		try {
			return repository.findByDireccionContaining(direccion);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	@Transactional
	public Gerente create(Gerente obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	@Override
	@Transactional
	public Gerente update(Gerente obj) {
		try {
			Gerente gerenteDb=repository.findById(obj.getId()).orElseGet(null);
			if (gerenteDb==null) {
				return null;	
			}
			gerenteDb.setNombre(obj.getNombre());
			gerenteDb.setCargo(obj.getCargo());
			gerenteDb.setRuc(obj.getRuc());
			gerenteDb.setDireccion(obj.getDireccion());
			return repository.save(gerenteDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Gerente gerenteDb=repository.findById(id).orElse(null);
			if (gerenteDb==null) {
				return 0;
			}else {
				repository.delete(gerenteDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}

	}



}
