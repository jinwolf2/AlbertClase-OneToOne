package com.example.probando.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="taquilla")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taquillas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_taquilla")
    private Long idTaquilla; // id_taquilla

    private String nombreTaquilla;

    private boolean ocupada;

    //falta conectarlo con Empleados
    @OneToOne(mappedBy = "taquilla")
    @JsonIgnore
    private Empleados empleado;
 

}
