package com.ecommes.app.service;

import java.util.List;

import com.ecommes.app.entity.Marca;

public interface IMarcaService {
	List<Marca> findAll();
	
	public Marca findById(Long id);
	
	public Marca save(Marca marca);
	
	public  void delete(Long id);
}
