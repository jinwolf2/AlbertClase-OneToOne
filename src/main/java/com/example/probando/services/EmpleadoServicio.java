package com.example.probando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.probando.entity.Empleados;
import com.example.probando.repositorio1.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    // get todos los empleados
    public List<Empleados> consultarEmpleados(){
        return empleadoRepositorio.findAll();
    }
 
    // ver uno solo
    public Optional<Empleados> verUnEmpleado(Long id){
        return empleadoRepositorio.findById(id);
    }

    // grabar un empleado
    public Empleados registEmpleados(Empleados empleado){
        return empleadoRepositorio.save(empleado);
    }

    // borrar uno por id
    public void borrarEmpleado(Long id){
        empleadoRepositorio.deleteById(id);
        System.out.println("cliente borrado!");
    }

}
