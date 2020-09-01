package com.ecommes.app.service;

import java.util.List;


import com.ecommes.app.entity.Pedido;

public interface IPedidoService {
	List<Pedido> findAll();
	
	public Pedido findById(Long id);
	
	public Pedido save(Pedido marca);
	
	public  void delete(Long id);

}
