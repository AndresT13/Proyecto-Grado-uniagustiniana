package com.ecommes.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.ecommes.app.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	


}
