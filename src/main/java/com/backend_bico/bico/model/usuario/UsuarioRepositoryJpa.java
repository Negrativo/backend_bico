package com.backend_bico.bico.model.usuario;

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

  @Query("SELECT usuario " +
      "FROM Usuario usuario " +
      "WHERE usuario.profissoes = :servico")
  List<Usuario> findByServico(String servico);

}
