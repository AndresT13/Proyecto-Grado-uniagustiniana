package com.ecommes.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommes.app.dao.IPedidoDao;
import com.ecommes.app.entity.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private IPedidoDao pedidoDao;

	@Override
	@Transactional(readOnly = true )
	public List<Pedido> findAll() {
		return (List<Pedido>) pedidoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public Pedido findById(Long id) {		
		return pedidoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pedido save(Pedido marca) {		
		return pedidoDao.save(marca);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		pedidoDao.deleteById(id);
		
	}

	

}
