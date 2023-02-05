package com.backend_bico.bico.model.usuario_cliente;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class UsuarioClienteRepositoryImpl implements UsuarioClienteRepository {

    private static final String USUARIO_NAO_ENCONTRADO = "USUÁRIO NÃO ENCONTRADO.";

    private final UsuarioClienteRepositoryJpa usuarioClienteRepositoryJpa;

    @Override
    public UsuarioCliente save(UsuarioCliente usuario) {
        return usuarioClienteRepositoryJpa.save(usuario);
    }

    @Override
    public List<UsuarioCliente> saveAll(Collection<UsuarioCliente> usuarios) {
        return usuarioClienteRepositoryJpa.saveAll(usuarios);
    }

    @Override
    public List<UsuarioCliente> findByIds(Collection<UUID> ids) {
        return usuarioClienteRepositoryJpa.findAllById(ids);
    }

    @Override
    public List<UsuarioCliente> findAll() {
        return usuarioClienteRepositoryJpa.findAll();
    }

    @Override
    public UsuarioCliente findById(UUID id) {
        Optional<UsuarioCliente> usuarioOptional = usuarioClienteRepositoryJpa.findById(id);
        return usuarioOptional.orElseThrow(() -> new EntityNotFoundException(USUARIO_NAO_ENCONTRADO));
    }

    @Override
    public void deleteById(UUID id) {
        UsuarioCliente usuarioEncontrado = findById(id);
        usuarioClienteRepositoryJpa.delete(usuarioEncontrado);
    }

}
