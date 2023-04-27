package com.backend_bico.bico.controller;

import com.backend_bico.bico.model.dtos.ServicoDoUsuarioDTO;
import com.backend_bico.bico.model.dtos.SolicitacaoDTO;
import com.backend_bico.bico.service.SolicitacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/solicitacao")
@AllArgsConstructor
public class SolicitacaoServicoController {

    private SolicitacaoService solicitacaoService;

    @PostMapping("/solicitar")
    public ResponseEntity<String> solicitar(@RequestBody SolicitacaoDTO solicitacaoDTO) {
        solicitacaoService.solicitar(solicitacaoDTO);
        return ResponseEntity.ok("Solicitado");
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<ServicoDoUsuarioDTO>> getSolicitacoesByUsuario(@PathVariable UUID usuarioId) {
        List<ServicoDoUsuarioDTO> servidoDoUsuario = solicitacaoService.getServidosDoUsuarioPrestador(usuarioId);
        return ResponseEntity.ok(servidoDoUsuario);
    }

}
