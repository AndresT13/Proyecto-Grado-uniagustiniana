package com.ecommes.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecommes.app.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
