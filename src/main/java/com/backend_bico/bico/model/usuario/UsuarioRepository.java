package com.backend_bico.bico.model.usuario;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);

    List<Usuario> saveAll(Collection<Usuario> usuarios);

    Usuario findById(UUID id);

    List<Usuario> findByIds(Collection<UUID> ids);

    List<Usuario> findAll();

    void deleteById(UUID id);


}
