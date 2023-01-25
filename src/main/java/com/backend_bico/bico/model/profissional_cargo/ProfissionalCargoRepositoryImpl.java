package com.backend_bico.bico.model.profissional_cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class ProfissionalCargoRepositoryImpl implements ProfissionalCargoRepository {

    private final ProfissionalCargoRepositoryJpa profissionalCargoRepositoryJpa;

    @Override
    public List<DropdownDTO> findAllForDropdown() {
        return profissionalCargoRepositoryJpa.findAllForDropdown();
    }

}
