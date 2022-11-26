package com.api.clinica.controller.dto.request;

import com.api.clinica.model.Funcionario;
import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class FuncionarioRequestDto {

    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private String setor;

    public Funcionario converter(ModelMapper modelMapper) {
        return modelMapper.map(this, Funcionario.class);
    }
}
