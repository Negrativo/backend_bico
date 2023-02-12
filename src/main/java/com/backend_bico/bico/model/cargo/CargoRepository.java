package com.backend_bico.bico.model.cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;

import java.util.List;
import java.util.Optional;

public interface CargoRepository {

    Optional<Cargo> findByNome(String nomeCargo);

    Optional<Cargo> findByNomeAndCategoria(String nomeCargo, String categoria);

    List<DropdownDTO> findAllForDropdown();

}
