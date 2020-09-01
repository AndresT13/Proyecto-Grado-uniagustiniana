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

import com.ecommes.app.entity.Categoria;
import com.ecommes.app.service.ICategoriaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CategoriaController {
	
	@Autowired
	public ICategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List<Categoria> list(){		
		return categoriaService.findAll();
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<?> Mostrar(@PathVariable Long id) {	
		
		Categoria categoria = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			categoria = categoriaService.findById(id);			
		} catch (DataAccessException e) {
			response.put("mensaje", "al consultar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} if (categoria == null) {
			response.put("mensaje", "La categoría ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
		}		
		
		return 	new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<?> Create( @RequestBody Categoria categoria) {
		Categoria categoriaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			categoriaNew = categoriaService.save(categoria);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", categoriaNew);
			
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("categorias/{id}")
	public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable Long id) {
		
		Categoria categoriaActual =  categoriaService.findById(id);
		Categoria categoriaUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			categoriaActual.setNombre(categoria.getNombre());
			categoriaActual.setCategoriaSuperior(categoria.getCategoriaSuperior());
			categoriaActual.setVisible(categoria.isVisible());
			categoriaActual.setCreateAt(categoria.getCreateAt());				
			
			categoriaUpdated = categoriaService.save(categoriaActual);			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		response.put("mensaje", "La categoría ha sido actualizado con éxito!");
		response.put("cliente", categoriaUpdated);	
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/categorias/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			categoriaService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La categoría ha sido eliminado con éxito." );
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	

}
