package com.ecommes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import com.ecommes.app.entity.Usuario;
import com.ecommes.app.service.IUsuarioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	// método para listar
	@GetMapping("/usuarios")
	public List<Usuario> usuario() {	
		return usuarioService.findAll();
	}
		
	// mostrar datos
	@GetMapping("/usuarios/{id}")
	public Usuario Mostrar(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	
	// metodo para crear
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {	
		//cliente.setCreateAt(new Date());
		return usuarioService.save(usuario);
	}
		
	//método para update o modificar o actualizar
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		
		
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setClave(usuario.getClave());
		usuarioActual.setTipo(usuario.getTipo());
		usuarioActual.setCreateAt(usuario.getCreateAt());
		
		//con un service voy a persistir el objeto actual internamente va a hacer un merge que va ha actualizar los datos y se traduce a un update en la base de datos
		return usuarioService.save(usuarioActual);
	}
	
	
	// metodo para delete
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}

}
