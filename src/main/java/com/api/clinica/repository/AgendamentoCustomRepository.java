package com.api.clinica.repository;


import com.api.clinica.model.Agendamento;
import com.api.clinica.model.enums.StatusAgendamento;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class AgendamentoCustomRepository {

    private EntityManager entityManager;

    public AgendamentoCustomRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Agendamento> findAll(String cpf, StatusAgendamento status){
        String jpql = "SELECT a FROM Agendamento a WHERE 1=1";
        if(cpf != null && !cpf.trim().isEmpty()){
            jpql += " AND a.paciente.cpf = :cpf";
        }
        if(status != null){
            jpql += " AND a.status = :status";
        }

        TypedQuery<Agendamento> query = entityManager.createQuery(jpql, Agendamento.class);
        if(cpf != null && !cpf.trim().isEmpty()){
            query.setParameter("cpf", cpf);
        }
        if(status != null){
            query.setParameter("status", status);
        }

        return query.getResultList();
    }

    public List<Agendamento> findMedicoAndPeriodOrStatus(Long idMedico, Integer dias, StatusAgendamento status){
        String jpql = "SELECT a FROM Agendamento a WHERE a.medico.id = :id";
        if(dias != null){
            if(dias < 0){
                jpql += " AND a.dataAgendada >= :dataAnterior AND a.dataAgendada < NOW()";
            } else {
                jpql += " AND a.dataAgendada >= NOW() AND a.dataAgendada <= :dataFutura";
            }
        }
        if(status != null){
            jpql += " AND a.status = :status";
        }

        TypedQuery<Agendamento> query = entityManager.createQuery(jpql, Agendamento.class);
        query.setParameter("id", idMedico);
        if(dias != null){
            if(dias < 0){
                LocalDate dataAnterior = LocalDate.now().minusDays(-dias);
                query.setParameter("dataAnterior", dataAnterior);
            } else {
                LocalDate dataFutura = LocalDate.now().plusDays(dias);
                query.setParameter("dataFutura", dataFutura);
            }
        }
        if(status != null){
            query.setParameter("status", status);
        }

        return query.getResultList();
    }
}
