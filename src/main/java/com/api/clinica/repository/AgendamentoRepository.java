package com.api.clinica.repository;

import com.api.clinica.model.Agendamento;
import com.api.clinica.model.enums.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByEspecialidade(Especialidade especialidade);

}
