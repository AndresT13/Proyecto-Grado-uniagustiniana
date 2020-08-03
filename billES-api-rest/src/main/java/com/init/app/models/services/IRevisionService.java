package com.init.app.models.services;

import java.util.List;

import com.init.app.models.entity.Revision;

public interface IRevisionService {
	
	public List<Revision> findAll();

}
