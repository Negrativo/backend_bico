package com.backend_bico.bico.model.servico_solicitado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ServicoSolicitadoRepositoryJpa extends JpaRepository<ServicoSolicitado, UUID> {

    @Query("SELECT servicoSolicitado " +
            "FROM ServicoSolicitado servicoSolicitado " +
            "WHERE servicoSolicitado.usuarioPrestador.id = :usuarioId")
    ServicoSolicitado findServicoSolicitadoByPrestador(UUID usuarioId);

    @Query("SELECT servicoSolicitado " +
            "FROM ServicoSolicitado servicoSolicitado " +
            "WHERE servicoSolicitado.servico.id = :servicoId")
    ServicoSolicitado findServicosSolicitadosByTipoServico(UUID servicoId);

}
