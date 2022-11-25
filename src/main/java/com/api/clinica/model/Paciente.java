package com.api.clinica.model;

import com.api.clinica.model.enums.Genero;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@Table(name = "tb_pacientes")
@Entity
public class Paciente extends Usuario {

    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private Genero sexo;
    private String endereco;
    private String contato;

}
