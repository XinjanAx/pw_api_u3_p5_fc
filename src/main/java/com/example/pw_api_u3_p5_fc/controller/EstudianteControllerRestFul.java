package com.example.pw_api_u3_p5_fc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p5_fc.repository.model.Estudiante;
import com.example.pw_api_u3_p5_fc.service.IEstudianteService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


//API: por el proyecto
//servicio -> controller: clase controller
@RestController//Servicio
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping(path="/buscar")   
    public Estudiante buscar(){
        return estudianteService.buscar(1);
    }

    @GetMapping(path="/consular")   
    public Estudiante consular(){
        return estudianteService.buscar(1);
    }

    @PostMapping(path="/guardar") 
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }

    @PutMapping(path="/actualizar")
    public void actualizar(Estudiante estudiante) {        
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path="/actualizarParcial")
    public void actualizarParcial(@RequestBody Estudiante estudiante){
        this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
    }

    @DeleteMapping(path="/borrar")
    public void borrar(){
        this.estudianteService.borrar(2);
    }
}
