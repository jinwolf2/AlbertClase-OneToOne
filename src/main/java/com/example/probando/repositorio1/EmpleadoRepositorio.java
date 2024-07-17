package com.example.probando.repositorio1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.probando.entity.Empleados;


public interface EmpleadoRepositorio extends JpaRepository<Empleados, Long>{

    
} 