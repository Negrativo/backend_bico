package com.backend_bico.bico.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServicoDoUsuarioDTO {

    private String usuarioSolicitante;
    private String servico;
    private String diaSelecionado;
    private String horarioSolicitado;
    private String observacao;
    private String endereco;

}
