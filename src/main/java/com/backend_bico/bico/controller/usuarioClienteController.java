package com.backend_bico.bico.controller;

import com.backend_bico.bico.model.usuario_cliente.UsuarioCliente;
import com.backend_bico.bico.model.usuario_cliente.UsuarioClienteService;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioAlterarSenhaDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioAtualizarDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioByIdDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioCriarDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario-cliente")
@RequiredArgsConstructor
public class usuarioClienteController {
    
    private final UsuarioClienteService usuarioClienteService;

    @PostMapping
    public ResponseEntity<UsuarioCliente> save(@RequestBody @Valid UsuarioCriarDTO usuarioDTO) {
        UsuarioCliente usuarioCliente = usuarioClienteService.save(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCliente);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioCliente>> findAll() {
        List<UsuarioCliente> usuarioClientes = usuarioClienteService.getAll();
        return ResponseEntity.ok(usuarioClientes);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioByIdDTO> findById(@PathVariable UUID usuarioId) {
        return ResponseEntity.ok(usuarioClienteService.findById(usuarioId));
    }

    @PutMapping(value = "/atualizar/{usuarioId}")
    public ResponseEntity<UsuarioCliente> update(@PathVariable UUID usuarioId, @RequestBody UsuarioAtualizarDTO usuarioAtualizarDTO) {
        return ResponseEntity.ok(usuarioClienteService.updateById(usuarioId, usuarioAtualizarDTO));
    }

    @PutMapping("/atualizar-senha/{usuarioId}")
    public void updateSenha(@PathVariable UUID usuarioId, @Valid @RequestBody UsuarioAlterarSenhaDTO usuarioAlterarSenhaDTO) {
        usuarioClienteService.updateSenha(usuarioId, usuarioAlterarSenhaDTO);
    }

    @DeleteMapping(value = "/deletar/{usuarioId}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID usuarioId) {
        usuarioClienteService.deleteById(usuarioId);
        return ResponseEntity.noContent().build();
    }

}
