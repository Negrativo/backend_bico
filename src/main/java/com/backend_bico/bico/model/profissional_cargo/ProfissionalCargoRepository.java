package com.backend_bico.bico.model.profissional_cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;

import java.util.List;

public interface ProfissionalCargoRepository {

    List<DropdownDTO> findAllForDropdown();

}
