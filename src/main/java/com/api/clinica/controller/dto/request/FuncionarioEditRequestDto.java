package com.api.clinica.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FuncionarioEditRequestDto {

    private String nome;
    private String email;
    private String senha;
    private String setor;

}
