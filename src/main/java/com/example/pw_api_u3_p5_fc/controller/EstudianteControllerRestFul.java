package com.example.pw_api_u3_p5_fc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p5_fc.repository.model.Estudiante;
import com.example.pw_api_u3_p5_fc.service.IEstudianteService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;





//API: por el proyecto
//servicio -> controller: clase controller
@RestController//Servicio
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping(path="buscar")   
    public Estudiante buscar(){
        return estudianteService.buscar(1);
    }

    //Metodos: capacidades
    public void guardar(Estudiante estudiante){
        
    }

    
}
