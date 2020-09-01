package com.ecommes.app.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ecommes.app.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	  Optional<Usuario> findByNombreUsuario(String nu);
	    boolean existsByNombreUsuario(String nu);
	    boolean existsByEmail(String email);


}
