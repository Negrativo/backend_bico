package com.backend_bico.bico.model.dtos;

import com.backend_bico.bico.model.servico.Servico;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class DropdownDTO {

    public static final String PATH = "com.backend_bico.bico.model.dtos.DropdownDTO";

    protected UUID id;
    protected String nome;

    public DropdownDTO(Servico servico) {
        this.id = servico.getId();
        this.nome = servico.getNome();
    }

}
