package com.api.clinica.service;

import com.api.clinica.model.Agendamento;
import com.api.clinica.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private AgendamentoRepository agendamentoRepository;
    private MedicoService medicoService;
    private PacienteService pacienteService;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, MedicoService medicoService, PacienteService pacienteService) {
        this.agendamentoRepository = agendamentoRepository;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    public Agendamento salvar(Agendamento agendamento, Long idMedico, Long idPaciente){
        agendamento.setMedico(medicoService.buscarPorId(idMedico));
        agendamento.setPaciente(pacienteService.buscarPorId(idPaciente));
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> buscarTodos(){
        return agendamentoRepository.findAll();
    }

}
