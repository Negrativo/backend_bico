package com.backend_bico.bico.model.servico_solicitado;

import com.backend_bico.bico.model.servico.Servico;
import com.backend_bico.bico.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "tb_servico_solicitado", schema = "bico")
public class ServicoSolicitado {

    @Id
    private final UUID id;

    @OneToOne
    @JoinColumn(name = "usuario_solicitando_id")
    private Usuario usuarioSolicitante;

    @OneToOne
    @JoinColumn(name = "usuario_prestador_id")
    private Usuario usuarioPrestador;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    private LocalDateTime diaSolicitado;

    private LocalTime horarioSolicitado;

    private String observacao;

    private String latitude;

    private String longitude;

    private String endereco;

    public ServicoSolicitado(Usuario usuarioSolicitante, Usuario usuarioPrestador, Servico servico, LocalDateTime diaSolicitado, LocalTime horarioSolicitado, String observacao, String latitude, String longitude, String endereco) {
        this.id = UUID.randomUUID();
        this.usuarioSolicitante = usuarioSolicitante;
        this.usuarioPrestador = usuarioPrestador;
        this.servico = servico;
        this.diaSolicitado = diaSolicitado;
        this.horarioSolicitado = horarioSolicitado;
        this.observacao = observacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
    }
}
