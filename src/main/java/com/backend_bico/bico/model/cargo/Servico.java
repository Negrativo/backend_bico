package com.backend_bico.bico.model.cargo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(force = true)
@Table(name = "tb_servico", schema = "bico")
public class Servico {

  @Id
  private final UUID id;

  @NonNull
  private final String nome;

  private final String categoria;

  public Servico(@NonNull String nome, String categoria) {
    this.id = UUID.randomUUID();
    this.nome = nome;
    this.categoria = categoria;
  }

}
