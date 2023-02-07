package com.backend_bico.bico.model.cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class CargoRepositoryImpl implements CargoRepository {

    private final CargoRepositoryJpa cargoRepositoryJpa;

    @Override
    public Optional<Cargo> findByNome(String nomeCargo) {
        return cargoRepositoryJpa.findByNome(nomeCargo);
    }

    @Override
    public Optional<Cargo> findByNomeAndCategoria(String nomeCargo, String categoria) {
        return cargoRepositoryJpa.findByNomeAndCategoria(nomeCargo, categoria);
    }

    @Override
    public List<DropdownDTO> findAllForDropdown() {
        return cargoRepositoryJpa.findAllForDropdown();
    }

}
