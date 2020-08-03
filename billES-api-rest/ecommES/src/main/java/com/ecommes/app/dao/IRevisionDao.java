package com.ecommes.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecommes.app.entity.Revision;

public interface IRevisionDao extends CrudRepository<Revision, Long> {

}
