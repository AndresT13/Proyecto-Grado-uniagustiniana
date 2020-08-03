package com.init.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.app.models.dao.IRevisionDao;
import com.init.app.models.entity.Revision;

@Service
public class RevisionServiceImpl implements IRevisionService {
	
	@Autowired
	private IRevisionDao revisionDao;

	@Override
	@Transactional(readOnly= true)
	public List<Revision> findAll() {		
		return  (List<Revision>) revisionDao.findAll();
	}

}
