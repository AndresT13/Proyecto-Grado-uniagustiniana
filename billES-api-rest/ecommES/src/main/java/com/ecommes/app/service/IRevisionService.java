package com.ecommes.app.service;

import java.util.List;

import com.ecommes.app.entity.Revision;


public interface IRevisionService {
	
	List<Revision> findAll();
	
	public Revision findById(Long id);
	//contrato del CRUD
	public Revision save(Revision revision);

	public void delete(Long id);

}
