package com.backend_bico.bico.model.usuario;

import com.backend_bico.bico.model.usuario.dto.UsuarioDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);

    void saveAll(Collection<Usuario> usuarios);

    Usuario findById(UUID id);

    List<Usuario> findByIds(Collection<UUID> ids);

    List<Usuario> findAll();

    void deleteById(UUID id);

    UsuarioDTO findByEmailAndSenha(String email, String senha);

    Optional<Usuario> verificarUsuarioExistente(String email);

    List<Usuario> findByServico(String servico);

    List<String> nomeServicosByUsuarioId(UUID id);

}
