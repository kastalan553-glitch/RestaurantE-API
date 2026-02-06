package com.restaurante.v1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @Column(columnDefinition = "CHAR(7)", unique = true, nullable = false)
    private String idpedido;

    @Column(columnDefinition = "CHAR(2)", nullable = false)
    private String nmesa;

    @JsonFormat(pattern = "HH:mm")
    @Column(nullable = false)
    private LocalTime hora;
    private int cantidad;

    @Column(columnDefinition = "VARCHAR(100)", unique = true, nullable = false)
    private String observacion;

    //pedido-plato
    @ManyToOne
    @JoinColumn(name = "idplato", nullable = false)
    private Plato plato;

    //pedido-mozos
    @ManyToOne
    @JoinColumn(name = "dnimozo", nullable = false)
    private Mozo mozo;
}
