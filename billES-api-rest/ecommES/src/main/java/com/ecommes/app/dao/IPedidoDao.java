package com.ecommes.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecommes.app.entity.Pedido;

public interface IPedidoDao extends CrudRepository<Pedido, Long> {

}
