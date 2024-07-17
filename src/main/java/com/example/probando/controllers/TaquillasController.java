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

import com.example.probando.entity.Taquillas;
import com.example.probando.persisjpa.dto.TaquillaDTO;
import com.example.probando.services.TaquillaServicio;

@RestController
@RequestMapping("/api")
public class TaquillasController {

    @Autowired
    private TaquillaServicio taquillaServicio;

    // ver todas las taquillas
    @GetMapping("/listarTaquillas")
    public List<Taquillas> consultarTaquillas() {
        return taquillaServicio.consultarTaquillas();
    }

    // ver una por Id
    @GetMapping("/listarTaquillas/{id}")
    public Optional<Taquillas> verUnaTaquilla(@PathVariable Long id){
        return taquillaServicio.verunaTaquilla(id);
    }

    // grabar una 
    @PostMapping("/registTaquilla")
    public Taquillas regisTaquillas(@RequestBody TaquillaDTO taquillaJson){
        Taquillas taquilla = new Taquillas();

        taquilla.setNombreTaquilla(taquillaJson.getNombreTaquilla());
        taquilla.setOcupada(taquillaJson.isOcupada());
        return taquillaServicio.regisTaquillas(taquilla);
    }

    // Modificar una por ID
    @PutMapping("/actualizarTaquilla/{id}")
    public Taquillas modificarTaquilla(@RequestBody TaquillaDTO taquillaJson, @PathVariable Long id) {
        Taquillas taquilla = new Taquillas();

        taquilla.setIdTaquilla(id);
        taquilla.setNombreTaquilla(taquillaJson.getNombreTaquilla());
        taquilla.setOcupada(taquillaJson.isOcupada());
       
        return taquillaServicio.regisTaquillas(taquilla);  
    }

    // Borrar una por ID
    @DeleteMapping("/borrarTaquilla/{id}")
    public void borrarTaquilla(Long id){
       taquillaServicio.borrarTaquilla(id); 
    }

    
}
