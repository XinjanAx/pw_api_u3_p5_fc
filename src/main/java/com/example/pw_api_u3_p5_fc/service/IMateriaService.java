package com.example.pw_api_u3_p5_fc.service;

import java.util.List;

import com.example.pw_api_u3_p5_fc.service.to.MateriaTO;

public interface IMateriaService {

    public List<MateriaTO> selecionarPorIDEstrudiante(Integer id);
}