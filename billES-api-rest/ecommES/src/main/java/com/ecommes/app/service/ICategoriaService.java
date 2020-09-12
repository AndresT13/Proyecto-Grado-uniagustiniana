package com.ecommes.app.service;

import java.util.List;

import com.ecommes.app.entity.Categoria;


public interface ICategoriaService  {
	List<Categoria> findAll();	
	
	public Categoria findById(Long id);
	
	public Categoria save(Categoria categoria);
	
	public void delete(Long id);

	
}
