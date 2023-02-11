package com.backend_bico.bico.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface UsuarioRepositoryJpa extends JpaRepository<Usuario, UUID> {

}
