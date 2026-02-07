package com.restaurante.v1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mozos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mozo {

    @Id
    @Column(columnDefinition = "CHAR(8)", nullable = false)
    private String dnimozo;
    
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;
	
	@Column(columnDefinition = "VARCHAR(80)",nullable = false)
    private String direccion;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaingreso;
	
	@Column(columnDefinition = "CHAR(10)", nullable = false)
    private String movil;
	
	@Column(columnDefinition = "VARCHAR(50)",nullable = false)
    private String email;
}
