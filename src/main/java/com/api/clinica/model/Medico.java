package com.api.clinica.model;

import com.api.clinica.model.enums.Especialidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Table(name = "tb_medicos")
@Entity
public class Medico extends Funcionario{

    private String crm;
    private Especialidade especialidade;

}
