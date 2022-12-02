package com.api.clinica.controller.dto.response;

import com.api.clinica.model.Medico;
import com.api.clinica.model.enums.Especialidade;
import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter @Setter
public class MedicoDto {

    private Long id;
    private String crm;
    private String nome;
    private Especialidade especialidade;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private String setor;
    private Boolean ativo;

    public static MedicoDto converter(Medico medico, ModelMapper modelMapper) {
        return modelMapper.map(medico, MedicoDto.class);
    }

    public static List<MedicoDto> converter(List<Medico> medicos, ModelMapper modelMapper){
        return medicos.stream().map(m -> MedicoDto.converter(m, modelMapper)).toList();
    }
}
