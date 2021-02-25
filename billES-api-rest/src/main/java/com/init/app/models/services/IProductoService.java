package com.init.app.models.services;

import java.util.List;

import com.init.app.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public List<Producto> findById();
	
	public List<Producto> create();

}
