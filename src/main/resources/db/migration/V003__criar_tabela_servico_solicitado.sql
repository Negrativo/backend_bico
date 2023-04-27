CREATE TABLE bico.tb_servico_solicitado (
     id uuid NOT NULL,
     usuario_solicitando_id uuid NOT NULL REFERENCES tb_usuario(id),
     usuario_prestador_id uuid REFERENCES tb_usuario(id),
     servico_id uuid REFERENCES tb_servico(id),
     dia_solicitado date NULL,
     horario_solicitado time NULL,
     observacao varchar(100) NULL,
     latitude varchar(100) NULL,
     longitude varchar(100) NULL,
     endereco varchar(100) NULL,
     CONSTRAINT tb_servico_solicitado_pkey PRIMARY KEY (id)
);
