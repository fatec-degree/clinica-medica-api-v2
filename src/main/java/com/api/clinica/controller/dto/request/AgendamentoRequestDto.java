package com.api.clinica.controller.dto.request;

import com.api.clinica.model.Agendamento;
import com.api.clinica.model.enums.Especialidade;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class AgendamentoRequestDto {

    private Long idPaciente;
    private Long idMedico;
    private Especialidade especialidade;
    private LocalDate dataCriacao;
    private LocalDate dataAgendada;
    private LocalTime horaAgendada;

    public Agendamento converter() {
        Agendamento agendamento = new Agendamento();
        agendamento.setEspecialidade(this.especialidade);
        agendamento.setDataCriacao(this.dataCriacao);
        agendamento.setDataAgendada(this.dataAgendada);
        agendamento.setHoraAgendada(this.horaAgendada);
        return agendamento;
    }

}
