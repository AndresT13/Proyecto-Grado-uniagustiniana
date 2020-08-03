package com.init.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.app.models.dao.ICategoriaDao;
import com.init.app.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;
	
	
	@Override
	@Transactional(readOnly= true)
	public List<Categoria> findAll() {
		
		return (List<Categoria>) categoriaDao.findAll();
	}
	

}
