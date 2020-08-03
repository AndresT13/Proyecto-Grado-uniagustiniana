package com.ecommes.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommes.app.dao.IRevisionDao;
import com.ecommes.app.entity.Revision;

@Service
public class RevisionServiceImpl implements IRevisionService{
	
	public IRevisionDao revisionDao;

	@Override
	public List<Revision> findAll() {		
		return  (List<Revision>) revisionDao.findAll();
	}

	@Override
	public Revision findById(Long id) {		
		return revisionDao.findById(id).orElse(null);
	}

	@Override
	public Revision save(Revision revision) {		
		return revisionDao.save(revision);
	}

	@Override
	public void delete(Long id) {		
		revisionDao.deleteById(id);
	}

}
