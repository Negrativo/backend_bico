package com.backend_bico.bico.model.usuario_cliente.dto;

import com.backend_bico.bico.model.usuario_cliente.UsuarioCliente;
import com.backend_bico.bico.model.usuario_profissional.UsuarioProfissional;
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

    public UsuarioByIdDTO(UsuarioCliente usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.verificatedAt = usuario.getVerificatedAt();
    }

    public UsuarioByIdDTO(UsuarioProfissional usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmailUsuario();
        this.verificatedAt = usuario.getVerificatedAt();
    }

}
