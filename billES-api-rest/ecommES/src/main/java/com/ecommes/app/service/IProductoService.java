package com.ecommes.app.service;

import java.util.List;

import com.ecommes.app.entity.Producto;


public interface IProductoService {
	
	List<Producto> findAll();
		
	public Producto findById(Long id);
	
	public Producto save(Producto producto);

	public void delete(Long id);
	
	
}

