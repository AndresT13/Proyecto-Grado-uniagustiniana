package com.ecommes.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommes.app.entity.Pedido;
import com.ecommes.app.service.IPedidoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PedidoController {

	@Autowired
	private IPedidoService pedidoService;
	
	
	@GetMapping("/pedidos")
	public List<Pedido> listar(){		
		return pedidoService.findAll();
	}
	
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<?> Mostrar(@PathVariable Long id) {
		
		Pedido pedido= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			pedido = pedidoService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "al consultar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (pedido == null) {
			response.put("mensaje", "El pedido ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@PostMapping("/pedidos")
	public ResponseEntity<?> Create(@RequestBody  Pedido pedido) {
		
		Pedido pedidoNew = null;
		Map<String, Object> response =new HashMap<>();
		
		try {
			pedidoNew = pedidoService.save(pedido);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		response.put("mensaje", "El pedido ha sido creado con éxito!");
		response.put("cliente", pedidoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED); 
		
	}	
	
	
	
	@PutMapping("/pedidos/{id}")
	public ResponseEntity<?> update(@RequestBody Pedido pedido, @PathVariable Long id) {
		Pedido pedidoActual = pedidoService.findById(id);
		Pedido pedidoUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			pedidoActual.setNumeropedido(pedido.getNumeropedido());
			pedidoActual.setStatus(pedido.getStatus());
			pedidoActual.setSubtotal(pedido.getSubtotal());
			pedidoActual.setCreateAt(pedido.getCreateAt());
			
			pedidoUpdated = pedidoService.save(pedidoActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El pedido ha sido actualizado con éxito!");
		response.put("cliente", pedidoUpdated);	
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	
	}
	
	@DeleteMapping("pedidos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			pedidoService.delete(id);			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		response.put("mensaje", "El pedido ha sido eliminado con écito! ");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
		
	}	
	
	
	
}
