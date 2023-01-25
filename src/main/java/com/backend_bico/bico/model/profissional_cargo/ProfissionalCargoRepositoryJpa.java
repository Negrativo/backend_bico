package com.backend_bico.bico.model.profissional_cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

interface ProfissionalCargoRepositoryJpa extends JpaRepository<ProfissionalCargo, UUID> {

    @Query("SELECT new " + DropdownDTO.PATH + "(cargo.id, cargo.nome) " +
            "FROM ProfissionalCargo cargo " +
            "ORDER BY cargo.nome")
    List<DropdownDTO> findAllForDropdown();

}
