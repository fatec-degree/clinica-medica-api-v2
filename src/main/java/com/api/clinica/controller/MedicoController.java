package com.api.clinica.controller;

import com.api.clinica.controller.dto.request.MedicoRequestDto;
import com.api.clinica.controller.dto.response.MedicoDto;
import com.api.clinica.model.Medico;
import com.api.clinica.service.MedicoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/medicos")
public class MedicoController {

    private MedicoService medicoService;
    private ModelMapper modelMapper;

    public MedicoController(MedicoService medicoService, ModelMapper modelMapper) {
        this.medicoService = medicoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicoDto salvar(@RequestBody MedicoRequestDto medicoRequestDto){
        return MedicoDto.converter(medicoService.salvar(medicoRequestDto.converter(modelMapper)), modelMapper);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicoDto> buscarTodos(){
        return MedicoDto.converter(medicoService.buscarTodos(), modelMapper);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoDto buscarPorId(@PathVariable Long id){
        return MedicoDto.converter(medicoService.buscarPorId(id), modelMapper);
    }

}
