package com.backend_bico.bico.model.usuario_cliente;

import com.backend_bico.bico.model.usuario_profissional.UsuarioProfissional;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@Table(name = "tb_usuario_cliente", schema = "bico")
public class UsuarioCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    private String nome;

    private String numeroTelefone;

    private String email;

    @JsonIgnore
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsuarioProfissional usuarioProfissional;

}
