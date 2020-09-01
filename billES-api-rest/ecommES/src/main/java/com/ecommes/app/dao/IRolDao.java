package com.ecommes.app.dao;



import org.springframework.data.repository.CrudRepository;

import com.ecommes.app.entity.Rol;

public interface IRolDao extends CrudRepository<Rol, Long> {
	
}
