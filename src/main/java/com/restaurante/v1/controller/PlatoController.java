package com.restaurante.v1.controller;

import com.restaurante.v1.entity.Plato;
import com.restaurante.v1.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    @Autowired
    private PlatoRepository platoRepository;

    @PostMapping("/agregar")
    public Plato crearPlato(@RequestBody Plato plato){
        return platoRepository.save(plato);
    }

    @GetMapping("/listar")
    public List<Plato> listarPlatos(){
        return  platoRepository.findAll();
    }
    
    
    @PutMapping("/actualizar/{id}")
    public Plato actualizarPlato(@PathVariable String id, @RequestBody Plato plato) {
    	return platoRepository.findById(id).map(plat ->{
    		plat.setDescripcion(plato.getDescripcion());
    		plat.setCostounitario(plato.getCostounitario());
    		plat.setCostofamiliar(plato.getCostofamiliar());
    		return platoRepository.save(plat);
    	}).orElse(null);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPlato(@PathVariable String id) {
        platoRepository.deleteById(id);
        return ResponseEntity.ok("Plato eliminado correctamente");
    }
}
