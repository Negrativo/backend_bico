package com.backend_bico.bico.model.cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository {

    Optional<Servico> findByNome(String nomeCargo);

    Optional<Servico> findByNomeAndCategoria(String nomeCargo, String categoria);

    List<DropdownDTO> findAllForDropdown();

}
