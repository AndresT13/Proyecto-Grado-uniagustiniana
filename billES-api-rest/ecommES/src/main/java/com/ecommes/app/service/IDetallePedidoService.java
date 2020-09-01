package com.ecommes.app.service;

import java.util.List;

import com.ecommes.app.entity.DetallePedido;

public interface IDetallePedidoService {
	List<DetallePedido> findAll();
	
	public DetallePedido findById(Long id);
	
	public DetallePedido save(DetallePedido detallePedido);
	
	public void delete (Long id);

}
