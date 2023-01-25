package com.backend_bico.bico.model.profissional_cargo;

import com.backend_bico.bico.model.cargo.Cargo;
import com.backend_bico.bico.model.usuario_profissional.UsuarioProfissional;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_profissional_cargo", schema = "bico")
public class ProfissionalCargo {

    @Id
    private UUID id;
    private UsuarioProfissional profissional;

    private List<Cargo> cargos;

    public ProfissionalCargo(UsuarioProfissional profissional, List<Cargo> cargos) {
        this.id = UUID.randomUUID();
        this.profissional = profissional;
        this.cargos = cargos;
    }

}
