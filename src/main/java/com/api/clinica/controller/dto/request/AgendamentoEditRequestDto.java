package com.api.clinica.controller.dto.request;

import com.api.clinica.model.enums.StatusAgendamento;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AgendamentoEditRequestDto {

    private StatusAgendamento status;

}
