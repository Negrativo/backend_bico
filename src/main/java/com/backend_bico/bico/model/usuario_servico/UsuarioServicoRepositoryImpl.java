package com.backend_bico.bico.model.usuario_servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@RequiredArgsConstructor
class UsuarioServicoRepositoryImpl implements UsuarioServicoRepository {

    private final UsuarioServicoRepositoryJpa usuarioServicoRepositoryJpa;

    @Override
    public UsuarioServico save(UsuarioServico usuario) {
        return usuarioServicoRepositoryJpa.save(usuario);
    }

    @Override
    public void saveAll(Collection<UsuarioServico> usuarios) {
        usuarioServicoRepositoryJpa.saveAll(usuarios);
    }

}