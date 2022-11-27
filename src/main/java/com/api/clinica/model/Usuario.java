package com.api.clinica.model;

import com.api.clinica.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Table(name = "tb_usuarios")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;
    private Boolean ativo = true;

}
