package com.backend_bico.bico.model.cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;

import java.util.List;
import java.util.Optional;

public interface CargoRepository {

    Optional<Cargo> findByNomeInCategoria(String nomeCargo, String cargoEnum);

    List<DropdownDTO> findAllForDropdown();

}
