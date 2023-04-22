package com.backend_bico.bico.model.cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface ServicoRepositoryJpa extends JpaRepository<Servico, UUID> {

    @Query("SELECT servico " +
            "FROM Servico servico " +
            "WHERE servico.nome = :nome")
    Optional<Servico> findByNome(String nome);

    @Query("SELECT servico " +
            "FROM Servico servico " +
            "WHERE servico.nome = :nome " +
            "AND servico.categoria = :categoria")
    Optional<Servico> findByNomeAndCategoria(String nome, String categoria);

    @Query("SELECT servico " +
            "FROM Servico servico " +
            "ORDER BY servico.nome")
    List<Servico> findAllForDropdown();

}
