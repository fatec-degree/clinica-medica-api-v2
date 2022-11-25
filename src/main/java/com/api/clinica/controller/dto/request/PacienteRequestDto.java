package com.api.clinica.controller.dto.request;

import com.api.clinica.model.Paciente;
import com.api.clinica.model.enums.Genero;
import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Getter @Setter
public class PacienteRequestDto {

    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private String cpf;
    private LocalDate dataNascimento;
    private Genero sexo;
    private String endereco;
    private String contato;

    public Paciente converter(ModelMapper modelMapper) {
        Paciente paciente = new Paciente();
        modelMapper.map(this, paciente);
        return paciente;
    }

}
