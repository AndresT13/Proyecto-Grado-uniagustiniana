package com.init.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.app.models.dao.IProductoDao;
import com.init.app.models.entity.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;
	
	
	@Override
	@Transactional(readOnly = true )
	public List<Producto> findAll() {		
		return (List<Producto>) productoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true )
	public Page<Producto> findAll(Pageable pageable) {
		return productoDao.findAll(pageable);
	}	
	

	@Override
	@Transactional(readOnly = false )
	public Producto findById(Long id) {		
		return productoDao.findById(id).orElse(null);		
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDao.deleteById(id);		
	}

}
