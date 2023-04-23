package com.backend_bico.bico.model.usuario.dto;

import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario_servico.UsuarioServico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UsuarioCriarDTO {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    private String telefone;

    private String latitude;

    private String longitude;

    private String endereco;

    public UsuarioCriarDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.telefone = usuario.getTelefone();
        this.latitude = usuario.getLatitude();
        this.longitude = usuario.getLongitude();
        this.endereco = usuario.getEndereco();
    }

}
