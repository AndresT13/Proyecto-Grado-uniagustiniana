package com.ecommes.app.service;

import java.util.List;

import com.ecommes.app.entity.Rol;

public interface IRolService {
	
	List<Rol> findAll();
	
	public Rol findById(Long id);
	
	public Rol save(Rol rol);
	
	public void delete(Long id);

}
