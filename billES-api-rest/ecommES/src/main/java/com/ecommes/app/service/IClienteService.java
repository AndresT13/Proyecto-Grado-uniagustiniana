package com.ecommes.app.service;

import java.util.List;


import com.ecommes.app.entity.Cliente;

public interface IClienteService {
	
	List<Cliente> findAll();	
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);

}
