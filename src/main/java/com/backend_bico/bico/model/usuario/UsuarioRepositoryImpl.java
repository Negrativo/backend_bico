package com.backend_bico.bico.model.usuario;

import com.backend_bico.bico.model.usuario.dto.UsuarioDTO;
import com.backend_bico.bico.model.usuario_servico.UsuarioServico;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
class UsuarioRepositoryImpl implements UsuarioRepository {

    private static final String USUARIO_NAO_ENCONTRADO = "USUÁRIO NÃO ENCONTRADO.";

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepositoryJpa.save(usuario);
    }

    @Override
    public void saveAll(Collection<Usuario> usuarios) {
        usuarioRepositoryJpa.saveAll(usuarios);
    }

    @Override
    public List<Usuario> findByIds(Collection<UUID> ids) {
        return usuarioRepositoryJpa.findAllById(ids);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepositoryJpa.findAll();
    }

    @Override
    public Usuario findById(UUID id) {
        Optional<Usuario> usuarioOptional = usuarioRepositoryJpa.findById(id);
        return usuarioOptional.orElseThrow(() -> new EntityNotFoundException(USUARIO_NAO_ENCONTRADO));
    }

    @Override
    public void deleteById(UUID id) {
        Usuario usuarioEncontrado = findById(id);
        usuarioRepositoryJpa.delete(usuarioEncontrado);
    }

    @Override
    public UsuarioDTO findByEmailAndSenha(String email, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepositoryJpa.findByEmailAndSenha(email, senha);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new EntityNotFoundException(USUARIO_NAO_ENCONTRADO));
        return new UsuarioDTO(usuario);
    }

    @Override
    public Optional<Usuario> verificarUsuarioExistente(String email) {
        return usuarioRepositoryJpa.findByEmail(email);
    }

    @Override
    public List<Usuario> findByServico(String servico) {
        return usuarioRepositoryJpa.findByServico(servico);
    }

    @Override
    public List<String> nomeServicosByUsuarioId(UUID id) {
        List<UsuarioServico> usuarioServicos = usuarioRepositoryJpa.nomeServicosByUsuarioId(id);
        return usuarioServicos.stream()
                .map(usuarioServico -> usuarioServico.getServico().getNome())
                .sorted()
                .collect(Collectors.toList());
    }

}