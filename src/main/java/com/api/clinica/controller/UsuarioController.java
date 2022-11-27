package com.api.clinica.controller;

import com.api.clinica.controller.dto.response.UsuarioDto;
import com.api.clinica.model.enums.TipoUsuario;
import com.api.clinica.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;
    private ModelMapper modelMapper;

    public UsuarioController(UsuarioService usuarioService, ModelMapper modelMapper) {
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> buscarPorTipo(@RequestParam(value = "tipo") TipoUsuario tipo){
        return UsuarioDto.converter(usuarioService.buscarUsuarioPorTipo(tipo), modelMapper);
    }

}
