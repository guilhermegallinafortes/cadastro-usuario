package com.guilherme.cadastro_usuario.controller;

import com.guilherme.cadastro_usuario.business.UsuarioService;
import com.guilherme.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(usuarioService.buscarPorCPF(cpf));

    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorCpf(@RequestParam String cpf) {
        usuarioService.deletarUsuarioPorCpf(cpf);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cpf")
    public ResponseEntity<Void> atualizarUsuarioPorCpf(@RequestParam String cpf, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorCpf(cpf, usuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/id")
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam int id, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorID(id, usuario);
        return ResponseEntity.ok().build();
    }
}
