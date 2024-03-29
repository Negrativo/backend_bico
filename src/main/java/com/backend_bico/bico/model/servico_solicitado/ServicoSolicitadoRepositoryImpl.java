package com.backend_bico.bico.model.servico_solicitado;

import com.backend_bico.bico.model.dtos.ServicoDoUsuarioDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
@RequiredArgsConstructor
public class ServicoSolicitadoRepositoryImpl implements ServicoSolicitadoRepository {

    private final ServicoSolicitadoRepositoryJpa servicoSolicitadoRepositoryJpa;

    @Override
    public void save(ServicoSolicitado servicoSolicitado) {
        servicoSolicitadoRepositoryJpa.save(servicoSolicitado);
    }

    @Override
    public List<ServicoSolicitado> findServicoSolicitadoByPrestador(UUID usuarioId) {
        return servicoSolicitadoRepositoryJpa.findServicoSolicitadoByPrestador(usuarioId);
    }

    @Override
    public ServicoSolicitado findServicosSolicitadosByTipoServico(UUID servicoId) {
        return servicoSolicitadoRepositoryJpa.findServicosSolicitadosByTipoServico(servicoId);
    }
}
