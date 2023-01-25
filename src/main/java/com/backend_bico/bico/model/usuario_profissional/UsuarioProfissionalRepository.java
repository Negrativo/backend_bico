package com.backend_bico.bico.model.usuario_profissional;

import com.backend_bico.bico.model.dtos.DropdownDTO;

import java.util.List;

public interface UsuarioProfissionalRepository {

    List<DropdownDTO> findAllForDropdown();

}
