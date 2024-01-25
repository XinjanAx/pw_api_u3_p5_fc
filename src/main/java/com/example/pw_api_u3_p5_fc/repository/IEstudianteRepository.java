package com.example.pw_api_u3_p5_fc.repository;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p5_fc.repository.model.Estudiante;

@Repository
public interface IEstudianteRepository {
    // CRUD
    // Create, Read, Update (total y parcial), Delete
    public void insertar(Estudiante estudiante);
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(String apellido, String nombre, Integer id);
    public Estudiante seleccionar(Integer id);
    public void eliminar(Integer id);
    
}
