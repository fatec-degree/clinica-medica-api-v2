package com.api.clinica.service;

import com.api.clinica.exceptions.ResourceNotFoundException;
import com.api.clinica.model.Funcionario;
import com.api.clinica.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario salvar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public List<Funcionario> buscarTodos(){
        return repository.findAllByAtivoTrue();
    }

    public Funcionario buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado."));
    }

    public void deletar(Long id){
        Funcionario funcionario = buscarPorId(id);
        funcionario.setAtivo(false);
    }
}
