package com.backend_bico.bico.model.historico_servico;

import com.backend_bico.bico.model.usuario_cliente.UsuarioCliente;
import com.backend_bico.bico.model.usuario_profissional.UsuarioProfissional;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_historico_servico", schema = "bico")
public class HistoricoServico {

    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UsuarioCliente usuarioCliente;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UsuarioProfissional usuarioProfissional;

    public HistoricoServico(UsuarioCliente usuarioCliente, UsuarioProfissional usuarioProfissional) {
        this.id = UUID.randomUUID();
        this.usuarioCliente = usuarioCliente;
        this.usuarioProfissional = usuarioProfissional;
    }


}
