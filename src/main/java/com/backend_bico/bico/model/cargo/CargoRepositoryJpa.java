package com.backend_bico.bico.model.cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface CargoRepositoryJpa extends JpaRepository<Cargo, UUID> {

    @Query("SELECT cargo.* FROM Cargo cargo " +
            "WHERE cargo.nome = :nome")
    Optional<Cargo> findByNomeInCategoria(String nome, CategoriaCargoEnum cargoEnum);

    @Query("SELECT new " + DropdownDTO.PATH + "(cargo.id, cargo.nome) " +
            "FROM Cargo cargo " +
            "ORDER BY cargo.nome")
    List<DropdownDTO> findAllForDropdown();

}
