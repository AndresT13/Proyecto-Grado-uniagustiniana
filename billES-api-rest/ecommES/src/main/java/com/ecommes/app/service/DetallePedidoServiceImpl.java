package com.ecommes.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommes.app.dao.IDetallePedidoDao;
import com.ecommes.app.entity.DetallePedido;



@Service
public class DetallePedidoServiceImpl  implements IDetallePedidoService {
	
	
	@Autowired
	private IDetallePedidoDao detallePedidoDao;

	@Override
	@Transactional(readOnly = true )
	public List<DetallePedido> findAll() {		
		return (List<DetallePedido>) detallePedidoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true )
	public DetallePedido findById(Long id) {		
		return detallePedidoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DetallePedido save(DetallePedido detallePedido) {		
		return detallePedidoDao.save(detallePedido);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		detallePedidoDao.deleteById(id);
		
	}

}
