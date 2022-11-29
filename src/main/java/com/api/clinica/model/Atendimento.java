package com.api.clinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@Table(name = "tb_atendimentos")
@Entity
public class Atendimento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_agendamento")
    private Agendamento agendamento;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao = LocalDate.now();
    private String descricao;

}
