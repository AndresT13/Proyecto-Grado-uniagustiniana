package com.init.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.app.models.dao.IMarcaDao;
import com.init.app.models.entity.Marca;

@Service
public class MarcaServiceImpl implements IMarcaService {
	
	
	@Autowired
	public IMarcaDao MarcaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findAll() {		
		return (List<Marca>) MarcaDao.findAll();
	}

}
