package com.api.clinica.service;

import com.api.clinica.model.Usuario;
import com.api.clinica.model.enums.TipoUsuario;
import com.api.clinica.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> buscarUsuarioPorTipo(TipoUsuario tipo){
        return repository.findByTipoUsuario(tipo);
    }

}
