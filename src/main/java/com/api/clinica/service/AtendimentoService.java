package com.api.clinica.service;

import com.api.clinica.model.Agendamento;
import com.api.clinica.model.Atendimento;
import com.api.clinica.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    private AtendimentoRepository repository;
    private AgendamentoService agendamentoService;

    public AtendimentoService(AtendimentoRepository repository, AgendamentoService agendamentoService) {
        this.repository = repository;
        this.agendamentoService = agendamentoService;
    }

    public Atendimento salvar(Atendimento atendimento, Long idAgendamento){
        Agendamento agendamento = agendamentoService.buscarPorId(idAgendamento);
        atendimento.setAgendamento(agendamento);
        return repository.save(atendimento);
    }

    public List<Atendimento> buscarTodos(Long idPaciente){
        if(idPaciente == null){
            return repository.findAll();
        }
        return repository.findByAgendamentoPacienteId(idPaciente);
    }

}
