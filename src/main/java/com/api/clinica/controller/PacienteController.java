package com.api.clinica.controller;

import com.api.clinica.controller.dto.request.PacienteRequestDto;
import com.api.clinica.controller.dto.request.PacienteRequestEditDto;
import com.api.clinica.controller.dto.response.PacienteDto;
import com.api.clinica.model.Paciente;
import com.api.clinica.service.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pacientes")
public class PacienteController {

    private PacienteService pacienteService;
    private ModelMapper modelMapper;

    public PacienteController(PacienteService pacienteService, ModelMapper modelMapper) {
        this.pacienteService = pacienteService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteDto salvar(@RequestBody PacienteRequestDto pacienteRequestDto){
        return PacienteDto.converter(pacienteService.salvar(pacienteRequestDto.converter(modelMapper)), modelMapper);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PacienteDto> buscarTodos(){
        return PacienteDto.converter(pacienteService.buscarTodos(), modelMapper);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDto buscarPorId(@PathVariable Long id){
        return PacienteDto.converter(pacienteService.buscarPorId(id), modelMapper);
    }

    @GetMapping(path = "/filter")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDto buscarPorCpf(@RequestParam(name = "cpf") String cpf){
        return PacienteDto.converter(pacienteService.buscarPorCpf(cpf), modelMapper);
    }

    @Transactional
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDto atualizar(@PathVariable Long id, @RequestBody PacienteRequestEditDto pacienteRequestEditDto){
        Paciente paciente = pacienteService.buscarPorId(id);
        modelMapper.map(pacienteRequestEditDto, paciente);
        return PacienteDto.converter(paciente, modelMapper);
    }
}
