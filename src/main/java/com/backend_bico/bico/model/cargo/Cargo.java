package com.backend_bico.bico.model.cargo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Entity
@Getter
@Table(name = "tb_cargo", schema = "bico")
public class Cargo {

    @Id
    private final UUID id;

    @NonNull
    private final String nome;

    private final String categoria;

    public Cargo(@NonNull String nome, String categoria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.categoria = categoria;
    }

}
