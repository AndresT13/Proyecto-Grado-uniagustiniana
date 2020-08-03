package com.init.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.init.app.models.entity.Revision;

public interface IRevisionDao  extends CrudRepository<Revision, Long>{

}
