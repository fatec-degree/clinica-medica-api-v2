package com.api.clinica.service;

import com.api.clinica.exceptions.ResourceNotFoundException;
import com.api.clinica.model.Agendamento;
import com.api.clinica.model.enums.StatusAgendamento;
import com.api.clinica.repository.AgendamentoCustomRepository;
import com.api.clinica.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private AgendamentoRepository agendamentoRepository;
    private AgendamentoCustomRepository agendamentoCustomRepository;
    private MedicoService medicoService;
    private PacienteService pacienteService;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, AgendamentoCustomRepository agendamentoCustomRepository, MedicoService medicoService, PacienteService pacienteService) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoCustomRepository = agendamentoCustomRepository;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    public Agendamento salvar(Agendamento agendamento, Long idMedico, Long idPaciente){
        agendamento.setMedico(medicoService.buscarPorId(idMedico));
        agendamento.setPaciente(pacienteService.buscarPorId(idPaciente));
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> buscarTodos(String cpf, StatusAgendamento status){
        return agendamentoCustomRepository.findAll(cpf, status);
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado."));
    }

    public List<Agendamento> buscarPorIdMedicoEPeriodoOuStatus(Long idMedico, Integer dias, StatusAgendamento status){
        return agendamentoCustomRepository.findMedicoAndPeriodOrStatus(idMedico, dias, status);
    }

}
