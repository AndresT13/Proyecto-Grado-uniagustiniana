package com.init.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.app.models.entity.Categoria;
import com.init.app.models.services.ICategoriaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CategoriasRestController {
	
	@Autowired
	public ICategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List<Categoria> categories(){		
		return categoriaService.findAll();
	}

}
