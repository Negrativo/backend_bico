package com.backend_bico.bico.model.usuario_cliente;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface UsuarioClienteRepository {

    UsuarioCliente save(UsuarioCliente usuario);

    List<UsuarioCliente> saveAll(Collection<UsuarioCliente> usuarios);

    UsuarioCliente findById(UUID id);

    List<UsuarioCliente> findByIds(Collection<UUID> ids);

    List<UsuarioCliente> findAll();

    void deleteById(UUID id);


}
