package com.api.clinica.controller;

import com.api.clinica.controller.dto.request.FuncionarioEditRequestDto;
import com.api.clinica.controller.dto.response.FuncionarioDto;
import com.api.clinica.controller.dto.request.FuncionarioRequestDto;
import com.api.clinica.model.Funcionario;
import com.api.clinica.service.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private ModelMapper modelMapper;

    public FuncionarioController(FuncionarioService funcionarioService, ModelMapper modelMapper) {
        this.funcionarioService = funcionarioService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioDto salvar(@RequestBody FuncionarioRequestDto funcionarioRequestDto){
        return FuncionarioDto.converter(funcionarioService.salvar(funcionarioRequestDto.converter(modelMapper)), modelMapper);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioDto> buscarTodos(){
        return FuncionarioDto.converter(funcionarioService.buscarTodos(), modelMapper);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioDto buscarPorId(@PathVariable Long id){
        return FuncionarioDto.converter(funcionarioService.buscarPorId(id), modelMapper);
    }

    @Transactional
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioDto atualizar(@PathVariable Long id, @RequestBody FuncionarioEditRequestDto funcionarioEditRequestDto){
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        modelMapper.map(funcionarioEditRequestDto, funcionario);
        return FuncionarioDto.converter(funcionario, modelMapper);
    }

    @Transactional
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        funcionario.setAtivo(false);
    }

}
