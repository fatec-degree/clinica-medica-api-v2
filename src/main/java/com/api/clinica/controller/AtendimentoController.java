package com.api.clinica.controller;

import com.api.clinica.controller.dto.request.AtendimentoRequestDto;
import com.api.clinica.controller.dto.response.AtendimentoDto;
import com.api.clinica.service.AtendimentoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/atendimentos")
public class AtendimentoController {

    private AtendimentoService atendimentoService;
    private ModelMapper modelMapper;

    public AtendimentoController(AtendimentoService atendimentoService, ModelMapper modelMapper) {
        this.atendimentoService = atendimentoService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtendimentoDto salvar(@RequestBody AtendimentoRequestDto atendimentoRequestDto){
        Long idAgendamento = atendimentoRequestDto.getIdAgendamento();
        return AtendimentoDto.converter(atendimentoService.salvar(atendimentoRequestDto.converter(), idAgendamento), modelMapper);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AtendimentoDto> buscarTodos(@RequestParam(value = "idPaciente", required = false) Long idPaciente){
        return AtendimentoDto.converter(atendimentoService.buscarTodos(idPaciente), modelMapper);
    }

}
