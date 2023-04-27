package com.backend_bico.bico.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SolicitacaoDTO {

  private UUID usuarioSolicitante;
  private String servico;
  private String diaSelecionado;
  private String horarioSolicitado;
  private String observacao;
  private String latitude;
  private String longitude;
  private String endereco;

}
