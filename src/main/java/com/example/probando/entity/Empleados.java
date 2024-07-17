package com.example.probando.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombre_empleado")
    private String nombreEmpleado;

    private String direccion;
    private int edad;
    private String puesto;

    //conectarlo con Taquillas
    @OneToOne
    @JoinColumn(name="taquilla_id", referencedColumnName = "id_taquilla")
    private Taquillas taquilla;
}
