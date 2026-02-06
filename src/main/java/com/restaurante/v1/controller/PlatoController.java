package com.restaurante.v1.controller;

import com.restaurante.v1.entity.Plato;
import com.restaurante.v1.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
