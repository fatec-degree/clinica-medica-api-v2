package com.api.clinica.service;

import com.api.clinica.exceptions.ResourceNotFoundException;
import com.api.clinica.model.Paciente;
import com.api.clinica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente salvar(Paciente paciente){
        return repository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado."));
    }

    public Paciente buscarPorCpf(String cpf){
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado."));
    }

    public List<Paciente> buscarTodos(){
        return repository.findAll();
    }

}
