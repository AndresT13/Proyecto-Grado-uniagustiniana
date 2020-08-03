package com.init.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.init.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}
 