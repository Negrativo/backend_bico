package com.backend_bico.bico.model.usuario_servico;

import java.util.Collection;
import java.util.List;

public interface UsuarioServicoRepository {

    UsuarioServico save(UsuarioServico usuario);

    void saveAll(Collection<UsuarioServico> usuarios);

}
