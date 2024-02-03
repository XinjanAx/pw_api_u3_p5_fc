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

@RestController//Servicio
@RequestMapping(path="/profesores")
public class ProfesorControllerRestFul {

    //http://localhost:8080/API/v1.0/Matricula/profesores

    @Autowired
    private IProfesorService profesorService;

    // /1
    @GetMapping(path="/{id}")   
    public Profesor consular(@PathVariable Integer id){
        return profesorService.buscar(id);
    }

    //
    @PostMapping
    public void guardar(@RequestBody Profesor profesor){
        this.profesorService.guardar(profesor);
    }

    // /2
    @PutMapping(path="/{id}")
    public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {        
        profesor.setId(id);
        this.profesorService.actualizar(profesor);
    }

    // /2
    @PatchMapping(path="/{id}")
    public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id){
        profesor.setId(id);
        this.profesorService.actualizarParcial(profesor.getNombre(),profesor.getApellido(),profesor.getId());
    }

    // /5
    @DeleteMapping(path="/{id}")
    public void borrar(@PathVariable Integer id){
        this.profesorService.borrar(id);
    }

    // ?genero=M
    @GetMapping
    public List<Profesor> consultarTodo(@RequestParam (required = false, defaultValue = "M") String genero) {
        return this.profesorService.consultarTodo(genero);
    }
}
