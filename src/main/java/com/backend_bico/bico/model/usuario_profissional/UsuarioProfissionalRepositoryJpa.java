package com.backend_bico.bico.model.usuario_profissional;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

interface UsuarioProfissionalRepositoryJpa extends JpaRepository<UsuarioProfissional, UUID> {

    @Query("SELECT new " + DropdownDTO.PATH + "(cargo.id, cargo.nome) " +
            "FROM Cargo cargo " +
            "ORDER BY cargo.nome")
    List<DropdownDTO> findAllForDropdown();

}
