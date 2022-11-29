package com.api.clinica.controller.dto.response;

import com.api.clinica.model.Atendimento;
import com.api.clinica.model.enums.Especialidade;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class AtendimentoDto {

    private Long id;
    private String descricao;
    private LocalDate dataCriacao;
    private Especialidade agendamentoEspecialidade;
    private String agendamentoMedicoNome;

    public static AtendimentoDto converter(Atendimento atendimento, ModelMapper modelMapper) {
        return modelMapper.map(atendimento, AtendimentoDto.class);
    }

    public static List<AtendimentoDto> converter(List<Atendimento> atendimentos, ModelMapper modelMapper) {
        return atendimentos.stream().map(a -> AtendimentoDto.converter(a, modelMapper)).toList();
    }

}
