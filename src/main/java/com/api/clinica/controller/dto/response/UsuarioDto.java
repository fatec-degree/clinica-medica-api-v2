package com.api.clinica.controller.dto.response;

import com.api.clinica.model.Usuario;
import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter @Setter
public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private Boolean ativo;

    public static UsuarioDto converter(Usuario usuario, ModelMapper modelMapper){
        return modelMapper.map(usuario, UsuarioDto.class);
    }

    public static List<UsuarioDto> converter(List<Usuario> usuarios, ModelMapper modelMapper) {
        return usuarios.stream().map(u -> UsuarioDto.converter(u, modelMapper)).toList();
    }

}
