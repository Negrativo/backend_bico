package com.backend_bico.bico.model.usuario_servico;

import com.backend_bico.bico.model.cargo.Servico;
import com.backend_bico.bico.model.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
@Table(name = "tb_usuario_servico", schema = "bico")
public class UsuarioServico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_usuario")
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "id_servico")
  private Servico servico;

}
