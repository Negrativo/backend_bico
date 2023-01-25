package com.backend_bico.bico.model.usuario_cliente;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface UsuarioClienteRepositoryJpa extends JpaRepository<UsuarioCliente, UUID> {

    @Query("SELECT usuario.* FROM Usuario usuario " +
            "WHERE usuario.nome = :nomeUser " +
            "AND usuario.email = :emailUser")
    Optional<UsuarioCliente> findByNomeAndEmail(String nomeUser, String emailUser);

    @Query("SELECT new " + DropdownDTO.PATH + "(cargo.id, cargo.nome) " +
            "FROM Cargo cargo " +
            "ORDER BY cargo.nome")
    List<DropdownDTO> findAllForDropdown();

}
