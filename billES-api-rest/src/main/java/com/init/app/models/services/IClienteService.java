package com.init.app.models.services;

import java.util.List;

import com.init.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
}
