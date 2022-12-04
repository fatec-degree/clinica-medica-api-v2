package com.api.clinica.controller;

import com.api.clinica.controller.dto.request.LoginDto;
import com.api.clinica.controller.dto.response.UsuarioDto;
import com.api.clinica.model.Funcionario;
import com.api.clinica.model.Usuario;
import com.api.clinica.model.enums.TipoUsuario;
import com.api.clinica.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
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

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UsuarioDto login(@RequestBody LoginDto loginDto){
        return UsuarioDto.converter(usuarioService.login(loginDto.getEmail(), loginDto.getSenha()), modelMapper);
    }

//    @GetMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public UsuarioDto buscarPorId(@PathVariable Long id){
//        return UsuarioDto.converter(usuarioService.buscarPorId(id), modelMapper);
//    }

    @GetMapping(path = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto buscarPorId(@PathVariable String email){
        return UsuarioDto.converter(usuarioService.buscarPorEmail(email), modelMapper);
    }

    @GetMapping(path = "/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> buscarPorTipo(@RequestParam(value = "tipo") TipoUsuario tipo){
        return UsuarioDto.converter(usuarioService.buscarUsuarioPorTipo(tipo), modelMapper);
    }

    @Transactional
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        usuario.setAtivo(false);
    }

}
