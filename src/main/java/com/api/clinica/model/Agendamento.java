package com.api.clinica.model;

import com.api.clinica.model.enums.Especialidade;
import com.api.clinica.model.enums.StatusAgendamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@Table(name = "tb_agendamentos")
@Entity
public class Agendamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "dataAgendada")
    private LocalDate dataAgendada;

    @Column(name = "horaAgendada")
    private LocalTime horaAgendada;

    private StatusAgendamento status = StatusAgendamento.AGENDADO;
    private Especialidade especialidade;

}
