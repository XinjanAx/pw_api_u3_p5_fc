package com.example.pw_api_u3_p5_fc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p5_fc.repository.model.Estudiante;
import com.example.pw_api_u3_p5_fc.service.IEstudianteService;

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
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;


    //metodos = capacidades
    @GetMapping(path="/{id}")   
    public Estudiante consular(@PathVariable Integer id){
        return estudianteService.buscar(id);
    }

    @PostMapping
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }

    @PutMapping(path="/{id}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {   
        estudiante.setId(id); 
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path="/{id}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id){
        estudiante.setId(id);
        this.estudianteService.actualizarParcial(estudiante.getNombre(),estudiante.getApellido(), estudiante.getId());
    }

    @DeleteMapping(path="/{id}")
    public void borrar(@PathVariable Integer id){
        this.estudianteService.borrar(id);
    }

    //http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodo?genero=M
    @GetMapping
    public List<Estudiante> consultarTodo(@RequestParam(required = false, defaultValue = "M") String genero) {
        return this.estudianteService.consultarTodo(genero);
    }
}
