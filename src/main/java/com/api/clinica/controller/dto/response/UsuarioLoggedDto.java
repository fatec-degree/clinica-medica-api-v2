package com.api.clinica.controller.dto.response;

import com.api.clinica.model.Usuario;
import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter @Setter
public class UsuarioLoggedDto {

    private Long id;
    private String nome;
    private TipoUsuario tipoUsuario;

    public static UsuarioLoggedDto converter(Usuario usuario, ModelMapper modelMapper){
        return modelMapper.map(usuario, UsuarioLoggedDto.class);
    }

    public static List<UsuarioLoggedDto> converter(List<Usuario> usuarios, ModelMapper modelMapper) {
        return usuarios.stream().map(u -> UsuarioLoggedDto.converter(u, modelMapper)).toList();
    }

}
