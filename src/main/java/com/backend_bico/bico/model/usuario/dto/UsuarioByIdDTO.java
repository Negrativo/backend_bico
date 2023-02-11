package com.backend_bico.bico.model.usuario.dto;

import com.backend_bico.bico.model.usuario.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class UsuarioByIdDTO {

    private UUID id;
    private String nome;
    private String email;
    private LocalDateTime verificatedAt;

    public UsuarioByIdDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.verificatedAt = usuario.getVerificatedAt();
    }

}
