package com.api.clinica.repository;

import com.api.clinica.model.Medico;
import com.api.clinica.model.enums.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByEspecialidadeAndAtivoTrue(Especialidade especialidade);

}
