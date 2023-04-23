package com.backend_bico.bico.model.usuario_servico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface UsuarioServicoRepositoryJpa extends JpaRepository<UsuarioServico, UUID> {

}
