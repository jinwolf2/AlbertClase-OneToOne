package com.example.probando.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.probando.entity.Empleados;
import com.example.probando.entity.Taquillas;
import com.example.probando.persisjpa.dto.EmpleadoDTO;
import com.example.probando.services.EmpleadoServicio;
import com.example.probando.services.TaquillaServicio;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private EmpleadoServicio servicioEmpleado;

    @Autowired
    private TaquillaServicio tServicio;

    @GetMapping("/listarEmpleados")
    public List<Empleados> consultarEmpleados() {
        return servicioEmpleado.consultarEmpleados();
    }

    @GetMapping("/listarEmpleados/{id}")
    public Optional<Empleados> consultarEmpleados(@PathVariable Long id) {
        return servicioEmpleado.verUnEmpleado(id);
    }

    @PostMapping("/registrarEmpleado")
    public Empleados registrarEmpleado(@RequestBody EmpleadoDTO empleadoJson) {

        Empleados empleado = new Empleados();
        empleado.setNombreEmpleado(empleadoJson.getNombreEmpleado());
        empleado.setDireccion(empleadoJson.getDireccion());
        empleado.setEdad(empleadoJson.getEdad());
        empleado.setPuesto(empleadoJson.getPuesto());

        if (empleadoJson.getIdTaquilla() != null) {
            Optional<Taquillas> taquillaOptional = tServicio.verunaTaquilla(empleadoJson.getIdTaquilla());
            if (!taquillaOptional.isPresent()) {
                throw new IllegalArgumentException("Taquilla no encontrada");
            }
            empleado.setTaquilla(taquillaOptional.get());
        }

        return servicioEmpleado.registEmpleados(empleado);
    }

    @PutMapping("/actualizarEmpleado/{id}")
    public Empleados modificarEmpleado(@RequestBody EmpleadoDTO empleadoJson, @PathVariable Long id) {
        Empleados empleado = new Empleados();

        empleado.setId(id);
        empleado.setNombreEmpleado(empleadoJson.getNombreEmpleado());
        empleado.setDireccion(empleadoJson.getDireccion());
        empleado.setEdad(empleadoJson.getEdad());
        empleado.setPuesto(empleadoJson.getPuesto());

        return servicioEmpleado.registEmpleados(empleado);
    }

    @DeleteMapping("borrarEmpleado/{id}")
    public void borrarEmpleado(@PathVariable Long id){
        servicioEmpleado.borrarEmpleado(id);
    }
}


