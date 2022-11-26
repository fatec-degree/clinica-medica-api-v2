package com.api.clinica.controller.dto.response;

import com.api.clinica.model.Funcionario;
import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter @Setter
public class FuncionarioDto {

    private Long id;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;
    private String setor;
    private Boolean ativo;

    public static FuncionarioDto converter(Funcionario funcionario, ModelMapper modelMapper) {
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        modelMapper.map(funcionario, funcionarioDto);
        return funcionarioDto;
    }

    public static List<FuncionarioDto> converter(List<Funcionario> funcionarios, ModelMapper modelMapper) {
        return funcionarios.stream().map(f -> FuncionarioDto.converter(f, modelMapper)).toList();
    }

}
