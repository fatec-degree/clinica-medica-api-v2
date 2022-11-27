package com.api.clinica.controller;

import com.api.clinica.controller.dto.request.AgendamentoEditRequestDto;
import com.api.clinica.controller.dto.request.AgendamentoRequestDto;
import com.api.clinica.controller.dto.response.AgendamentoDto;
import com.api.clinica.model.Agendamento;
import com.api.clinica.model.enums.StatusAgendamento;
import com.api.clinica.service.AgendamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
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

    @GetMapping(path = "/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<AgendamentoDto> buscarTodosComFiltro(@RequestParam(value = "cpf") String cpf,
                                                  @RequestParam(value = "status") StatusAgendamento status){
        return AgendamentoDto.converter(agendamentoService.buscarPorPacienteCpf(cpf, status), modelMapper);
    }

    @Transactional
    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoDto atualizarStatus(@PathVariable Long id, @RequestBody AgendamentoEditRequestDto agendamentoEditRequestDto){
        Agendamento agendamento = agendamentoService.buscarPorId(id);
        agendamento.setStatus(agendamentoEditRequestDto.getStatus());
        return AgendamentoDto.converter(agendamento, modelMapper);
    }

}
