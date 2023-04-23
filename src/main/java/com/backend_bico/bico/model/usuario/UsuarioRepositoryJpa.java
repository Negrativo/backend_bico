package com.backend_bico.bico.model.usuario;

import com.backend_bico.bico.model.usuario_servico.UsuarioServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface UsuarioRepositoryJpa extends JpaRepository<Usuario, UUID> {

    @Query("SELECT usuario " +
            "FROM Usuario usuario " +
            "WHERE usuario.email = :email " +
            "AND usuario.senha = :senha")
    Optional<Usuario> findByEmailAndSenha(String email, String senha);

    @Query("SELECT usuario " +
            "FROM Usuario usuario " +
            "WHERE usuario.email = :email")
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT us.usuario " +
            "FROM UsuarioServico us " +
            "WHERE us.servico.nome = :servicoNome")
    List<Usuario> findByServico(String servicoNome);

    @Query("SELECT usuario.servicos " +
            "FROM Usuario usuario " +
            "JOIN UsuarioServico usuarioServico ON usuarioServico.usuario.id = usuario.id " +
            "WHERE usuario.id = :id")
    List<UsuarioServico> nomeServicosByUsuarioId(UUID id);
}
