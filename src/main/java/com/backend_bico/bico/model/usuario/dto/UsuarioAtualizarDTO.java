package com.backend_bico.bico.model.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAtualizarDTO {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private String telefone;

}