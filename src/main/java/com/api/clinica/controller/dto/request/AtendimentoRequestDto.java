package com.api.clinica.controller.dto.request;

import com.api.clinica.model.Atendimento;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AtendimentoRequestDto {

    private Long idAgendamento;
    private String descricao;


    public Atendimento converter() {
        Atendimento atendimento = new Atendimento();
        atendimento.setDescricao(this.descricao);
        return atendimento;
    }

}
