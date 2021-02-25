package com.init.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.init.app.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long> {

}
 