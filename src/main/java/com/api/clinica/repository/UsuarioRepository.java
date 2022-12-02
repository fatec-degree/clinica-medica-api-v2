package com.api.clinica.repository;

import com.api.clinica.model.Usuario;
import com.api.clinica.model.enums.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByTipoUsuarioAndAtivoTrue(TipoUsuario tipo);

    Optional<Usuario> findByEmail(String email);

}
