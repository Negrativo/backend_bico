package com.backend_bico.bico.model.usuario;

import com.backend_bico.bico.exceptionHandler.InvalidPasswordException;
import com.backend_bico.bico.model.usuario.dto.UsuarioAlterarSenhaDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioAtualizarDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioCriarDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.backend_bico.bico.model.usuario.UsuarioService.AS_SENHAS_NAO_CONFEREM;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuario", schema = "bico")
public class Usuario {

    @Id
    private UUID id;

    @NonNull
    private String nome;

    @NonNull
    private String email;

    @JsonIgnore
    private String senha;

    private String telefone;

    private String descricao;

    private String empregos;

    private String latitude;

    private String longitude;

    private String endereco;

    @Column(name = "verificated_at")
    private LocalDateTime verificatedAt;

    public Usuario(UsuarioCriarDTO usuarioDTO) {
        this.id = UUID.randomUUID();
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.telefone = usuarioDTO.getTelefone();
    }

    public void update(UsuarioAtualizarDTO atualizarUsuarioDTO) {
        this.nome = atualizarUsuarioDTO.getNome();
        this.email = atualizarUsuarioDTO.getEmail();
        this.telefone = atualizarUsuarioDTO.getTelefone();
    }

    public void updateSenha(String senha) {
        this.senha = senha;
    }

    public void validarSenhas(UsuarioAlterarSenhaDTO usuarioAlterarSenhaDTO) {
        String senha = usuarioAlterarSenhaDTO.getNovaSenha();
        String confirmarSenha = usuarioAlterarSenhaDTO.getConfirmarSenha();
        if (!senha.equals(confirmarSenha)) {
            throw new InvalidPasswordException(AS_SENHAS_NAO_CONFEREM);
        }
    }

}
