package com.restaurante.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/actualizar/{id}")
	public Mozo actualizarMozo(@PathVariable String id, @RequestBody Mozo mozo) {
		return mozoRepository.findById(id).map(mzo ->{
			mzo.setNombre(mzo.getNombre());
			mzo.setDireccion(mzo.getDireccion());
			mzo.setFechaingreso(mzo.getFechaingreso());
			mzo.setMovil(mzo.getMovil());
			mzo.setEmail(mzo.getEmail());
			return mozoRepository.save(mzo);
		}).orElse(null);
	}
	
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarMozo(@PathVariable String id) {
        mozoRepository.deleteById(id);
        return ResponseEntity.ok("Mozo eliminado correctamente.");
    }
}
