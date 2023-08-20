package com.backend_bico.bico.model.servico;

import com.backend_bico.bico.model.usuario_servico.UsuarioServico;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(force = true)
@Table(name = "tb_servico", schema = "public")
public class Servico {

    @Id
    private final UUID id;

    @NonNull
    private final String nome;

    private final String categoria;

    @OneToMany(mappedBy = "servico")
    private List<UsuarioServico> usuarioServicos;

    public Servico(@NonNull String nome, String categoria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.categoria = categoria;
        this.usuarioServicos = new ArrayList<>();
    }

    public void setUsuarioServico(UsuarioServico usuarioServico) {
        this.usuarioServicos.add(usuarioServico);
    }

}
