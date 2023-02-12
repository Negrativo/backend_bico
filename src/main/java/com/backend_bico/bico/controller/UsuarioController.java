package com.backend_bico.bico.controller;

import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioService;
import com.backend_bico.bico.model.usuario.dto.UsuarioAlterarSenhaDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioAtualizarDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioByIdDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioCriarDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioCriarDTO usuarioDTO) {
        Usuario usuario = usuarioService.save(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioService.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioByIdDTO> findById(@PathVariable UUID usuarioId) {
        return ResponseEntity.ok(usuarioService.findById(usuarioId));
    }

    @PutMapping(value = "/atualizar/{usuarioId}")
    public ResponseEntity<Usuario> update(@PathVariable UUID usuarioId, @RequestBody UsuarioAtualizarDTO usuarioAtualizarDTO) {
        return ResponseEntity.ok(usuarioService.updateById(usuarioId, usuarioAtualizarDTO));
    }

    @PutMapping("/atualizar-senha/{usuarioId}")
    public void updateSenha(@PathVariable UUID usuarioId, @Valid @RequestBody UsuarioAlterarSenhaDTO usuarioAlterarSenhaDTO) {
        usuarioService.updateSenha(usuarioId, usuarioAlterarSenhaDTO);
    }

    @DeleteMapping(value = "/deletar/{usuarioId}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID usuarioId) {
        usuarioService.deleteById(usuarioId);
        return ResponseEntity.noContent().build();
    }

}
