package com.backend_bico.bico.model.usuario_cliente;

import com.backend_bico.bico.exceptionHandler.InvalidPasswordException;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioAlterarSenhaDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioAtualizarDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioCriarDTO;
import com.backend_bico.bico.model.usuario_profissional.UsuarioProfissional;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.backend_bico.bico.model.usuario_cliente.UsuarioClienteService.AS_SENHAS_NAO_CONFEREM;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuario_cliente", schema = "bico")
public class UsuarioCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @NonNull
    private String nome;

    @NonNull
    private String email;

    @JsonIgnore
    private String senha;

    private String numeroTelefone;

    @Column(name = "verificated_at")
    private LocalDateTime verificatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsuarioProfissional usuarioProfissional;

    public UsuarioCliente(UsuarioCriarDTO usuarioDTO) {
        this.id = UUID.randomUUID();
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.numeroTelefone = usuarioDTO.getNumeroTelefone();
    }

    public void update(UsuarioAtualizarDTO atualizarUsuarioDTO) {
        this.nome = atualizarUsuarioDTO.getNome();
        this.email = atualizarUsuarioDTO.getEmail();
        this.numeroTelefone = atualizarUsuarioDTO.getNumeroTelefone();
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
