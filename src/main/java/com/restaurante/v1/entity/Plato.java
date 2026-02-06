package com.restaurante.v1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "platos")
public class Plato {
    @Id
    @Column(columnDefinition = "CHAR(5)", unique = true, nullable = false)
    private String idplato;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String descripcion;

    private Double costounitario;

    private Double costofamiliar;
}
