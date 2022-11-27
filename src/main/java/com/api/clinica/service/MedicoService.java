package com.api.clinica.service;

import com.api.clinica.exceptions.ResourceNotFoundException;
import com.api.clinica.model.Medico;
import com.api.clinica.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico salvar(Medico medico){
        return repository.save(medico);
    }

    public List<Medico> buscarTodos(){
        return repository.findAll();
    }

    public Medico buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado."));
    }

}
