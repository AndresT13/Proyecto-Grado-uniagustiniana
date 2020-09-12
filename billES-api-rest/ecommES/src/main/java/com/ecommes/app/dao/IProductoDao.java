package com.ecommes.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommes.app.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long> {
	//Obtener un producto
	//Optional<Producto> findByNombreProducto(String np);
	//comprobar si existe uno con un nombre determinado
	//boolean existsByNombreProducto(String np);

}
