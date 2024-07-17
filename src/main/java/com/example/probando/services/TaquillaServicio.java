package com.example.probando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.probando.entity.Taquillas;
import com.example.probando.repositorio1.TaquillaRepositorio;

@Service
public class TaquillaServicio {
    
    @Autowired
    private TaquillaRepositorio taquillaRepositorio;

    // listar taquillas
    public List<Taquillas> consultarTaquillas(){
        return taquillaRepositorio.findAll();
    }

    // ver una sola taquilla
    public Optional<Taquillas> verunaTaquilla(Long id){
        return taquillaRepositorio.findById(id);
    }

    // grabar una taquilla
     public Taquillas regisTaquillas(Taquillas taquilla){
        return taquillaRepositorio.save(taquilla);
     }

     // borrar una por id
     public void borrarTaquilla(Long id){
        taquillaRepositorio.deleteById(id);
        System.out.println("taquilla borrada");
     }



}
