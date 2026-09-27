package com.guilherme.cadastro_usuario.infrastructure.repository;

import com.guilherme.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCpf(String cpf);

    @Transactional
    void deleteByCpf(String cpf);
}
