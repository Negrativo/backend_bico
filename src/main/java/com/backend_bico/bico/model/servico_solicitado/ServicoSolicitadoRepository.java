package com.backend_bico.bico.model.servico_solicitado;

import com.backend_bico.bico.model.dtos.ServicoDoUsuarioDTO;

import java.util.List;
import java.util.UUID;

public interface ServicoSolicitadoRepository {

    void save(ServicoSolicitado servicoSolicitado);

    List<ServicoSolicitado> findServicoSolicitadoByPrestador(UUID usuarioId);

    ServicoSolicitado findServicosSolicitadosByTipoServico(UUID servicoId);

}
