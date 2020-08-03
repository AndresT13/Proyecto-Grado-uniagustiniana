package com.ecommes.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecommes.app.entity.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long>{

}
