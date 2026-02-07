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
	
	@PutMapping("/actualizar/{id}")
	public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		return usuarioRepository.findById(id).map(usu ->{
			usu.setNombre(usuario.getNombre());
            usu.setClave(usuario.getClave());
            return usuarioRepository.save(usu);
		}).orElse(null);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
		usuarioRepository.deleteById(id);
		return ResponseEntity.ok("Usurio eliminado");
	}
}
