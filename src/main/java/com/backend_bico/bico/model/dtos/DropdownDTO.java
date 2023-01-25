package com.backend_bico.bico.model.dtos;

import com.backend_bico.bico.model.cargo.Cargo;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class DropdownDTO {

    public static final String PATH = "com.backend_bico.bico.model.dtos.DropdownDTO";

    protected UUID id;
    protected String nome;

    public DropdownDTO(Cargo cargo) {
        this.id = cargo.getId();
        this.nome = cargo.getNome();
    }

}
