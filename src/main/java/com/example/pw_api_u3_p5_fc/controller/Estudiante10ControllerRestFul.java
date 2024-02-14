package com.example.pw_api_u3_p5_fc.controller;

import org.springframework.web.bind.annotation.RestController;


import com.example.pw_api_u3_p5_fc.service.IEstudiante10Service;
import com.example.pw_api_u3_p5_fc.service.to.Estudiante10TO;
import com.example.pw_api_u3_p5_fc.service.to.EstudianteLigeroTO;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(path="/estudiantes10")
public class Estudiante10ControllerRestFul {
    @Autowired
    private IEstudiante10Service estudianteService;

    @GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)   
    public ResponseEntity<Estudiante10TO> consular(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.buscar(id));
    }

    @GetMapping(path="/ligeros/{id}",produces = MediaType.APPLICATION_JSON_VALUE)   
    public ResponseEntity<EstudianteLigeroTO> consularLigero(@PathVariable Integer id){
        EstudianteLigeroTO ligero = this.estudianteService.buscarLigero(id);
        Link link = linkTo(methodOn(Estudiante10ControllerRestFul.class).consular(id)).withRel("estudiante completo");
        ligero.add(link);
        return ResponseEntity.status(HttpStatus.OK).body(ligero);
    }

}
