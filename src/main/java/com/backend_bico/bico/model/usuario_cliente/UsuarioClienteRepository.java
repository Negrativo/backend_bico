package com.backend_bico.bico.model.usuario_cliente;

import com.backend_bico.bico.model.dtos.DropdownDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioClienteRepository {

    Optional<UsuarioCliente> findByNomeAndEmail(String nomeUser, String emailUser);

    List<DropdownDTO> findAllForDropdown();

}
