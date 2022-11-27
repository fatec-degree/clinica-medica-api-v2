package com.api.clinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Table(name = "tb_funcionarios")
@Entity
public class Funcionario extends Usuario{

    private String setor;

}
