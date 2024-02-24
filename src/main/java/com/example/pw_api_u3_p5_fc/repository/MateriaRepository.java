package com.example.pw_api_u3_p5_fc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.pw_api_u3_p5_fc.repository.model.Materia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class MateriaRepository implements IMateriaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Materia> SeleccionarPorIdEstudiante(Integer id) {
        // TODO Auto-generated method stub
        TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id =: valor1", Materia.class);
		myQuery.setParameter("valor1", id);
		return myQuery.getResultList();
    }
    
}
