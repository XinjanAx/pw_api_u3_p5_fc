package com.example.pw_api_u3_p5_fc.controller;

import org.springframework.web.bind.annotation.RestController;


import com.example.pw_api_u3_p5_fc.repository.model.Profesor;

import com.example.pw_api_u3_p5_fc.service.IProfesorService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
@RequestMapping(path="/profesores")
public class ProfesorControllerRestFul {

    //http://localhost:8080/API/v1.0/Matricula/profesores

    @Autowired
    private IProfesorService profesorService;

    // /consultar/1
    @GetMapping(path="/consultar/{id}")   
    public Profesor consular(@PathVariable Integer id){
        return profesorService.buscar(id);
    }

    // /guardar
    @PostMapping(path="/guardar") 
    public void guardar(@RequestBody Profesor profesor){
        this.profesorService.guardar(profesor);
    }

    // /actualizar
    @PutMapping(path="/actualizar")
    public void actualizar(@RequestBody Profesor profesor) {        
        this.profesorService.actualizar(profesor);
    }

    // /actualizarParcial
    @PatchMapping(path="/actualizarParcial")
    public void actualizarParcial(@RequestBody Profesor profesor){
        this.profesorService.actualizarParcial(profesor.getApellido(), profesor.getNombre(), profesor.getId());
    }

    // /borrar/5
    @DeleteMapping(path="/borrar/{id}")
    public void borrar(@PathVariable Integer id){
        this.profesorService.borrar(id);
    }

    // /consultarTodo?genero=M
    @GetMapping(path="/consultarTodo")
    public List<Profesor> consultarTodo(@RequestParam String genero) {
        return this.profesorService.consultarTodo(genero);
    }
    

}
