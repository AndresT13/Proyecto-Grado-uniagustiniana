package com.init.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.init.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
	

}
