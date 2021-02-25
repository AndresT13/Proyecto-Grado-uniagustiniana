package com.init.app.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.init.app.models.entity.Producto;

public interface IProductoService {
	
	List<Producto> findAll();
	
	Page<Producto> findAll(Pageable pageable);		
		
	public Producto findById(Long id);
	
	public Producto save(Producto producto);

	public void delete(Long id);

}
