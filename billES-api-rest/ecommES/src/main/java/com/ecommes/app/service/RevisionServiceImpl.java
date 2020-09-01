package com.ecommes.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommes.app.dao.IRevisionDao;
import com.ecommes.app.entity.Revision;

@Service
public class RevisionServiceImpl implements IRevisionService{
	
	@Autowired
	public IRevisionDao revisionDao;

	@Override
	@Transactional(readOnly = true )
	public List<Revision> findAll() {		
		return  (List<Revision>) revisionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Revision findById(Long id) {		
		return revisionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Revision save(Revision revision) {		
		return revisionDao.save(revision);
	}

	@Override
	@Transactional
	public void delete(Long id) {		
		revisionDao.deleteById(id);
	}

}
