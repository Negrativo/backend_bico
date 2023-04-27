package com.backend_bico.bico.model.servico_solicitado;

import java.util.UUID;

public interface ServicoSolicitadoRepository {

    void save(ServicoSolicitado servicoSolicitado);

    ServicoSolicitado findServicoSolicitadoByPrestador(UUID usuarioId);

    ServicoSolicitado findServicosSolicitadosByTipoServico(UUID servicoId);

}
