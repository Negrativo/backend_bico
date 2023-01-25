package com.backend_bico.bico.model.usuario_profissional;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class UsuarioProfissionalRepositoryImpl implements UsuarioProfissionalRepository {

    private final UsuarioProfissionalRepositoryJpa usuarioProfissionalRepositoryJpa;

    @Override
    public List<DropdownDTO> findAllForDropdown() {
        return usuarioProfissionalRepositoryJpa.findAllForDropdown();
    }

}
