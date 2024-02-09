package com.example.pw_api_u3_p5_fc.repository;

import java.util.List;

import com.example.pw_api_u3_p5_fc.repository.model.Materia;

public interface IMateriaRepository {
    public List<Materia>  SeleccionarPorIdEstudiante(Integer id);
}
