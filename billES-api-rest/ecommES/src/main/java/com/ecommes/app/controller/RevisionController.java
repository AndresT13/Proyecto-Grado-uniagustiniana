package com.ecommes.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommes.app.entity.Revision;
import com.ecommes.app.service.IRevisionService;

@RestController
@RequestMapping("/api")
public class RevisionController {
	
	
	private IRevisionService revisionService;
	
	
	@GetMapping("/revisiones")
	public List<Revision> revision() {
		return revisionService.findAll();
	}
			
	// mostrar datos
	@GetMapping("/revisiones/{id}")
	public Revision Mostrar(@PathVariable Long id) {
		return revisionService.findById(id);
	}
	
	
	// metodo para crear
	@PostMapping("/revisiones")
	@ResponseStatus(HttpStatus.CREATED)
	public Revision create(@RequestBody Revision revision) {	
		//cliente.setCreateAt(new Date());
		return revisionService.save(revision);
	}
		
	//método para update o modificar o actualizar
	@PutMapping("/revisiones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Revision update(@RequestBody Revision revision, @PathVariable Long id) {
		
		Revision revisionActual = revisionService.findById(id);
		
		
		revisionActual.setNombre(revision.getNombre());
		revisionActual.setCorreo(revision.getCorreo());
		revisionActual.setComentario(revision.getComentario());
		revisionActual.setEstrellas(revision.getEstrellas());
		
		
		//con un service voy a persistir el objeto actual internamente va a hacer un merge que va ha actualizar los datos y se traduce a un update en la base de datos
		return revisionService.save(revisionActual);
	}
	
	
	// metodo para delete
	@DeleteMapping("/revisiones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		revisionService.delete(id);
	}
	

}
