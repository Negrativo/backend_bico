package com.backend_bico.bico.model.cargo;

import com.backend_bico.bico.model.dtos.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
class ServicoRepositoryImpl implements ServicoRepository {

    private final ServicoRepositoryJpa servicoRepositoryJpa;

    @Override
    public Optional<Servico> findByNome(String nomeCargo) {
        return servicoRepositoryJpa.findByNome(nomeCargo);
    }

    @Override
    public Optional<Servico> findByNomeAndCategoria(String nomeCargo, String categoria) {
        return servicoRepositoryJpa.findByNomeAndCategoria(nomeCargo, categoria);
    }

    @Override
    public List<DropdownDTO> findAllForDropdown() {
        List<Servico> allForDropdown = servicoRepositoryJpa.findAllForDropdown();
        return allForDropdown.stream()
                .map(DropdownDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Servico> findAll() {
        return servicoRepositoryJpa.findAll();
    }

    @Override
    public List<Servico> saveAll(Collection<Servico> servicos) {
        return servicoRepositoryJpa.saveAll(servicos);
    }
}
