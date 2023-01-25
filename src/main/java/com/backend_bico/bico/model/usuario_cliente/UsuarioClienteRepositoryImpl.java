package com.backend_bico.bico.model.usuario_cliente;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class UsuarioClienteRepositoryImpl implements UsuarioClienteRepository {

    private final UsuarioClienteRepositoryJpa usuarioClienteRepositoryJpa;

    @Override
    public Optional<UsuarioCliente> findByNomeAndEmail(String nomeUser, String emailUser) {
        return usuarioClienteRepositoryJpa.findByNomeAndEmail(nomeUser, emailUser);
    }

    @Override
    public List<DropdownDTO> findAllForDropdown() {
        return usuarioClienteRepositoryJpa.findAllForDropdown();
    }

}
