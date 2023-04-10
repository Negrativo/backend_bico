package com.backend_bico.bico.model.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SolicitacaoDTO {

  private String servico;
  private String diaSolicitado;
  private String horarioSolicitado;
  private String observacao;
  private String latitude;
  private String longitude;
  private String endereco;

}
