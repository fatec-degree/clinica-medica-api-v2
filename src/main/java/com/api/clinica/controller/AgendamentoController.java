package com.api.clinica.controller;

import com.api.clinica.controller.dto.request.AgendamentoRequestDto;
import com.api.clinica.controller.dto.response.AgendamentoDto;
import com.api.clinica.service.AgendamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/agendamentos")
public class AgendamentoController {

    private AgendamentoService agendamentoService;
    private ModelMapper modelMapper;

    public AgendamentoController(AgendamentoService agendamentoService, ModelMapper modelMapper) {
        this.agendamentoService = agendamentoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoDto salvar(@RequestBody AgendamentoRequestDto agendamentoRequestDto){
        Long idMedico = agendamentoRequestDto.getIdMedico();
        Long idPaciente = agendamentoRequestDto.getIdPaciente();
        return AgendamentoDto.converter(agendamentoService.salvar(agendamentoRequestDto.converter(), idMedico, idPaciente), modelMapper);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AgendamentoDto> buscarTodos(){
        return AgendamentoDto.converter(agendamentoService.buscarTodos(), modelMapper);
    }

}
