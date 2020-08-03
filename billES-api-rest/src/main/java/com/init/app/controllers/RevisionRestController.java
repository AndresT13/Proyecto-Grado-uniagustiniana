package com.init.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.app.models.entity.Revision;
import com.init.app.models.services.IRevisionService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RevisionRestController {
	
	@Autowired
	private IRevisionService  revisionService;
	
	
	@GetMapping("/revision")
	public List<Revision> revision() {
		return revisionService.findAll();
	}

}
