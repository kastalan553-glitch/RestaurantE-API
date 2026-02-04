package com.restaurante.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.v1.entity.Usuario;
import com.restaurante.v1.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/agregar")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		 return usuarioRepository.save(usuario);
	 }
	
	@GetMapping("/listar")
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}

}
