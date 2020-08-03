package com.init.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.init.app.models.entity.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long>  {
	


}
