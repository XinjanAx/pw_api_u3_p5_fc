package com.example.pw_api_u3_p5_fc.service;

import java.util.List;

import com.example.pw_api_u3_p5_fc.repository.model.Estudiante;
import com.example.pw_api_u3_p5_fc.service.to.EstudianteTO;

public interface IEstudianteService {
    public void guardar (Estudiante estudiante);
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(String apellido, String nombre, Integer Id);
    public Estudiante buscar(Integer id);
    public EstudianteTO buscarTO(Integer id);

    public void borrar(Integer id);
    public List<Estudiante>consultarTodo(String genero);
    public List<EstudianteTO>consultarTodoTO();


}
