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

import static com.backend_bico.bico.service.UsuarioService.AS_SENHAS_NAO_CONFEREM;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

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

    private ArrayList<String> profissoes;

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
        this.latitude = usuarioDTO.getLatitude();
        this.longitude = usuarioDTO.getLongitude();
        this.endereco = usuarioDTO.getEndereco();
        this.profissoes = usuarioDTO.getProfissoes();
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
