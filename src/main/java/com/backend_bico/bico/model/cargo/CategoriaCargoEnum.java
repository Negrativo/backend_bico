package com.backend_bico.bico.model.cargo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

@Getter
@RequiredArgsConstructor
public enum CategoriaCargoEnum {

    REFORMAS_E_REPAROS("REFORMAS E REPAROS"),
    ASSISTENCIA_TECNICA("ASSISTENCIA TÉCNICA"),
    SERVICOS_DOMESTICOS("SERVICOS DOMÉSTICOS"),
    FESTAS_E_EVENTOS("FESTAS E EVENTOS"),
    CONSULTORIA("CONSULTORIA"),
    AUTOS("AUTOS");

    @ColumnTransformer(write = "UPPER(?)")
    private final String valor;

}
