package com.backend_bico.bico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_bico.bico.model.dtos.SolicitacaoDTO;
import com.backend_bico.bico.service.SolicitacaoService;

import lombok.AllArgsConstructor;

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

}
