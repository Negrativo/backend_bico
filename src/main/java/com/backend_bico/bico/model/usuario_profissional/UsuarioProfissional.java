package com.backend_bico.bico.model.usuario_profissional;

import com.backend_bico.bico.model.profissional_cargo.ProfissionalCargo;
import com.backend_bico.bico.model.usuario_cliente.UsuarioCliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_profissional", schema = "bico")
public class UsuarioProfissional {

    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UsuarioCliente usuarioCliente;

    private ProfissionalCargo profissionalCargo;

    //Futuramente estudar metodologia melhor para geolocalização
    private int cordenadaX;
    private int cordenadaY;

    public UsuarioProfissional(UsuarioCliente usuarioCliente) {
        this.id = UUID.randomUUID();
        this.usuarioCliente = usuarioCliente;
    }

}
