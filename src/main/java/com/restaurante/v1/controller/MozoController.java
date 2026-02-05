package com.restaurante.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.v1.entity.Mozo;
import com.restaurante.v1.repository.MozoRepository;

@RestController
@RequestMapping("/api/mozos")
public class MozoController {
	@Autowired
	private MozoRepository mozoRepository;
	
	@PostMapping("/agregar")
	public Mozo crearMozo(@RequestBody Mozo mozo) {
		return mozoRepository.save(mozo);
	}
	
	@GetMapping("/listar")
	public List<Mozo> listarMozos(){
		return mozoRepository.findAll();
	}

	
}
