package com.backend_bico.bico.model.usuario.dto;

import com.backend_bico.bico.model.usuario.Usuario;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class UsuarioDTO {

    private final UUID id;

    private final String nome;

    private final String email;

    private final String telefone;

    private final List<String> servicos;

    private final String latitude;

    private final String longitude;

    private final String endereco;

    private final LocalDateTime verificatedAt;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.servicos = getNomeServicos(usuario);
        this.latitude = usuario.getLatitude();
        this.longitude = usuario.getLongitude();
        this.endereco = usuario.getEndereco();
        this.verificatedAt = usuario.getVerificatedAt();
    }

    private List<String> getNomeServicos(Usuario usuario) {
        return usuario.getServicos().stream()
                .map(usuarioServico -> usuarioServico.getServico().getNome())
                .collect(Collectors.toList());
    }
}
