package com.backend_bico.bico.model.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAlterarSenhaDTO {

    @NotBlank
    private String senhaAtual;

    @NotNull
    @Size(min = 8, max = 20)
    private String novaSenha;

    @NotNull
    @Size(min = 8, max = 20)
    private String confirmarSenha;

}
