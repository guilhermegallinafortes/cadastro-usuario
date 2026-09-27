package com.guilherme.cadastro_usuario.business;

import com.guilherme.cadastro_usuario.infrastructure.entitys.Usuario;
import com.guilherme.cadastro_usuario.infrastructure.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuariosRepository usuarios;

    public UsuarioService(UsuariosRepository usuariosRepository) {
        this.usuarios = usuariosRepository;
    }

    public void salvar(Usuario usuario) {
        usuarios.saveAndFlush(usuario);
    }

    public Usuario buscarPorCPF(String cpf) {
        return usuarios.findByCpf(cpf).orElseThrow(
            () -> new RuntimeException("CPF não encontrado")
        );
    }

    public void deletarUsuarioPorCpf(String cpf) {
        usuarios.deleteByCpf(cpf);
    }

    public void atualizarUsuarioPorCpf(String cpf, Usuario usuario) {
        Usuario usuarioEntity = buscarPorCPF(cpf);
        Usuario usuarioAtualizado = Usuario.builder().email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .cpf(cpf)
                .id(usuarioEntity.getId())
                .build();

        usuarios.saveAndFlush(usuarioAtualizado);
    }

    public void atualizarUsuarioPorID(Integer id, Usuario usuario) {
        Usuario usuarioEntity = usuario.getId() != null ? usuarios.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado")) : null;
        Usuario usuarioAtualizado = Usuario.builder().email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .cpf(usuario.getCpf() != null ? usuario.getCpf() : usuarioEntity.getCpf())
                .id(id)
                .build();

        usuarios.saveAndFlush(usuarioAtualizado);
    }
}
