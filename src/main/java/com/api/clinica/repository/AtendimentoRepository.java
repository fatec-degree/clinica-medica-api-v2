package com.api.clinica.repository;

import com.api.clinica.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    List<Atendimento> findByAgendamentoPacienteId(Long id);

}
