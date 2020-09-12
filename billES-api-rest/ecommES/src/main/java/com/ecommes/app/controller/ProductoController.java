package com.ecommes.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommes.app.entity.Producto;
import com.ecommes.app.service.IProductoService;


@CrossOrigin(origins = { "http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoController {
	

	@Autowired
	private IProductoService productoService;

	// método ´para listar productos
	@GetMapping("/productos")
	public List<Producto> producto() {
		return productoService.findAll();
	}
	
	@GetMapping("/productos/page/{page}")
	public Page<Producto> producto(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 16);
		return productoService.findAll(pageable);
	}

	// mostrar datos
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> Mostrar(@PathVariable Long id) {
		
		Producto producto = null;
		Map<String, Object> response = new HashMap<>();
		
		try{
			producto = productoService.findById(id);
		} 
		catch(DataAccessException e) {
			response.put("mensaje", "al consultar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		if(producto == null) {
			response.put("mensaje", "El producto ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);  
	}

	// metodo para crear
	@PostMapping("/productos")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Producto producto) {
			
		Producto productoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {			
			productoNew = productoService.save(producto);			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", productoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED); 
		}
	
	

	

	// método para update o modificar o actualizar
	@PutMapping("/productos/{id}")
	//@ResponseStatus(HttpStatus.CREATED)
	
	
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id) {

				
		Producto productoActual = productoService.findById(id);		
		Producto productoUpdated = null;		
		Map<String, Object> response = new HashMap<>();
		
		if(productoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, producto ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}

		try {			
			productoActual.setNombre(producto.getNombre());
			productoActual.setRefproducto(producto.getRefproducto());
			productoActual.setCantidad(producto.getCantidad());
			productoActual.setValorneto(producto.getValorneto());
			productoActual.setValortotal(producto.getValortotal());
			//productoActual.setImg(producto.getImg());
			productoActual.setVisible(producto.isNuevo());
			productoActual.setNuevo(producto.isNuevo());
			productoActual.setRecomendado(producto.isRecomendado());
			productoActual.setCreateAt(producto.getCreateAt());
			
			productoUpdated = productoService.save(productoActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El producto ha sido actualizado con éxito!");
		response.put("cliente", productoUpdated);			
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

		// con un service voy a persistir el objeto actual internamente va a hacer un
		// merge que va ha actualizar los datos y se traduce a un update en la base de
		// datos
		
	}	
	

	// metodo para delete
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {		
		Map<String, Object> response = new HashMap<>();
	
		try {
			productoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El producto ha sido eliminado con éxito." );
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	@PostMapping(value="/productos/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		
		Producto producto = productoService.findById(id);
		
		if(!file.isEmpty()) {
			String nombreArchivo = file.getOriginalFilename();
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			try {
				Files.copy(file.getInputStream(), rutaArchivo );
			} catch (IOException e) {
				response.put("cliente", producto);
				response.put("mensaje", "Error al subir la imagen en la base de datos " + nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			producto.setFoto(nombreArchivo);			
			//Actualizar Cliente
			productoService.save(producto);
			
			response.put("cliente", producto);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);			
		}		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

}
