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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommes.app.entity.Rol;
import com.ecommes.app.service.IRolService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RolController {
	
	@Autowired
	private IRolService rolService;
	
	
	@GetMapping("/roles")
	private List<Rol> List(){
		return rolService.findAll();		
	}
	
	@GetMapping("/roles/{id}")
	public ResponseEntity<?> Mostrar(@PathVariable Long id) {
		Rol rol = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			rol = rolService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "al consultar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(rol == null) {
			response.put("mensaje", "El rol ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);
	}	
	
	
	@PostMapping("/roles")
	public  ResponseEntity<?> create(@RequestBody Rol rol) {
		
		Rol rolNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			rolNew = rolService.save(rol);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El rol  ha sido creado con éxito!");
		response.put("cliente", rolNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED); 
	}
	
	@PutMapping("/roles/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public  ResponseEntity<?> update(@RequestBody Rol rol, @PathVariable Long id) {
		
		Rol rolActual = rolService.findById(id);	
		Rol rolUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (rolActual == null) {
			response.put("mensaje", "Error: no se pudo editar, rol ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			rolActual.setRol(rol.getRol());	
			
			rolUpdated = rolService.save(rolActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El rol ha sido actualizado con éxito!");
		response.put("cliente", rolUpdated);	
					
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/roles/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public  ResponseEntity<?> delete( @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			rolService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El rol ha sido eliminado con éxito." );
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);		
		
	}
	
}
