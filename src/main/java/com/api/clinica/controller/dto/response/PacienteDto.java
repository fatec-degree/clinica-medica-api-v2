package com.api.clinica.controller.dto.response;

import com.api.clinica.model.Paciente;
import com.api.clinica.model.enums.Genero;
import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class PacienteDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private String cpf;
    private LocalDate dataNascimento;
    private Genero sexo;
    private String endereco;
    private String contato;

    public static PacienteDto converter(Paciente paciente, ModelMapper modelMapper){
        return modelMapper.map(paciente, PacienteDto.class);
    }

    public static List<PacienteDto> converter(List<Paciente> pacientes, ModelMapper modelMapper){
        return pacientes.stream().map(p -> PacienteDto.converter(p, modelMapper)).toList();
    }
}
