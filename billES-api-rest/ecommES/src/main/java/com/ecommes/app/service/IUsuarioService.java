package com.ecommes.app.service;

import java.util.List;

import com.ecommes.app.entity.Usuario;

public interface IUsuarioService {
	
	List<Usuario> findAll();
	
	public Usuario findById(Long id);
	//contrato del CRUD
	public Usuario save(Usuario usuario);

	public void delete(Long id);
}