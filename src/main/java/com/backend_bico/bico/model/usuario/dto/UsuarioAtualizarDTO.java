package com.backend_bico.bico.model.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAtualizarDTO {

    private String latitude;

    private String longitude;

    private String endereco;

    private List<String> profissoes;

}
