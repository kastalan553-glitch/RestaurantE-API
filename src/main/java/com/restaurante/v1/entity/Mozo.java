package com.restaurante.v1.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mozos")
public class Mozo {

    @Id
    @Column(columnDefinition = "CHAR(8)")
    private String dni_mozo;
    private String nombre;
    private String direccion;
    private LocalDate fech_ingreso;
    private String movil;
    private String email;
}
