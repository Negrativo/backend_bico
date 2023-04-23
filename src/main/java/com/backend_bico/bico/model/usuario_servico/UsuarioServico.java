package com.backend_bico.bico.model.usuario_servico;

import com.backend_bico.bico.model.cargo.Servico;
import com.backend_bico.bico.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(force = true)
@Table(name = "tb_usuario_servicos", schema = "bico")
public class UsuarioServico {

    @Id
    private final UUID id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private final Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private final Servico servico;

    public UsuarioServico(Usuario usuario, Servico servico) {
        this.id = UUID.randomUUID();
        this.usuario = usuario;
        this.servico = servico;
    }

}
