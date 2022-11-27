package com.api.clinica.controller.dto.response;

import com.api.clinica.model.Agendamento;
import com.api.clinica.model.enums.Especialidade;
import com.api.clinica.model.enums.StatusAgendamento;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter @Setter
public class AgendamentoDto {

    private Long id;
    private String pacienteNome;
    private String pacienteCpf;
    private String pacienteContato;
    private String medicoNome;
    private Especialidade especialidade;
    private LocalDate dataCriacao;
    private LocalDate dataAgendada;
    private LocalTime horaAgendada;
    private StatusAgendamento status;

    public static AgendamentoDto converter(Agendamento agendamento, ModelMapper modelMapper) {
        return modelMapper.map(agendamento, AgendamentoDto.class);
    }

    public static List<AgendamentoDto> converter(List<Agendamento> agendamentos, ModelMapper modelMapper) {
        return agendamentos.stream().map(a -> AgendamentoDto.converter(a, modelMapper)).toList();
    }

}
