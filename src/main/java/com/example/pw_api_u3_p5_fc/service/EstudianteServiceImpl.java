package com.example.pw_api_u3_p5_fc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_fc.repository.IEstudianteRepository;
import com.example.pw_api_u3_p5_fc.repository.model.Estudiante;

@Service
public class EstudianteServiceImpl  implements IEstudianteService{
    @Autowired
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public void guardar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.actualizar(estudiante);
    }

    @Override
    public void actualizarParcial(String apellido, String nombre, Integer Id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.actualizarParcial(apellido, nombre, Id);
    }

    @Override
    public Estudiante buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.iEstudianteRepository.seleccionar(id);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.eliminar(id);
    }

    @Override
    public List<Estudiante> consultarTodo(String genero) {
        // TODO Auto-generated method stub
        return this.iEstudianteRepository.consultarTodo(genero);
    }
}
