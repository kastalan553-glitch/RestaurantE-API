package com.restaurante.v1.controller;

import com.restaurante.v1.entity.Pedido;
import com.restaurante.v1.repository.PedidoRepository;
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

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping("/agregar")
    public Pedido crearPedido(@RequestBody Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/listar")
    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }
    
    @PutMapping("/actualizar/{id}")
    public Pedido actualizarPedido(@PathVariable String id, @RequestBody Pedido pedido) {
    	return pedidoRepository.findById(id).map(ped ->{
    		ped.setNmesa(pedido.getNmesa());
    		ped.setHora(pedido.getHora());
    		ped.setCantidad(pedido.getCantidad());
    		ped.setObservacion(pedido.getObservacion());
    		ped.setPlato(pedido.getPlato());
    		ped.setMozo(pedido.getMozo());
    		return pedidoRepository.save(ped);
    	}).orElse(null);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPlato(@PathVariable String id) {
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok("Plato eliminado correctamente");
    }
}
