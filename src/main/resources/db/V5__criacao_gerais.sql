CREATE TABLE myorg.tb_usuario_cliente (
	id uuid NOT NULL,
	nome varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	senha varchar(80) NOT NULL,
	usuario_profissional_id uuid NOT NULL,
	CONSTRAINT tb_usuario_cliente_pkey PRIMARY KEY (id),
	CONSTRAINT tb_usuario_profissional_id_fkey FOREIGN KEY (usuario_profissional_id) REFERENCES bico.tb_usuario_profissional_pkey(id)
);

CREATE TABLE myorg.tb_usuario_profissional (
	id uuid NOT NULL,
	usuario_cliente_id uuid NOT NULL,
    profissional_cargo_id uuid NULL,
	CONSTRAINT tb_usuario_profissional_pkey PRIMARY KEY (id),
	CONSTRAINT tb_usuario_cliente_id_fkey FOREIGN KEY (usuario_cliente_id) REFERENCES bico.tb_usuario_cliente_pkey(id),
	CONSTRAINT tb_profissional_cargo_id_fkey FOREIGN KEY (profissional_cargo_id) REFERENCES bico.tb_profissional_cargo_pkey(id)
);

CREATE TABLE myorg.tb_usuario_profissional (
	id uuid NOT NULL,
	usuario_cliente_id uuid NOT NULL,
    profissional_cargo_id uuid NULL,
	CONSTRAINT tb_usuario_profissional_pkey PRIMARY KEY (id),
	CONSTRAINT tb_usuario_cliente_id_fkey FOREIGN KEY (usuario_cliente_id) REFERENCES bico.tb_usuario_cliente_pkey(id),
	CONSTRAINT tb_profissional_cargo_id_fkey FOREIGN KEY (profissional_cargo_id) REFERENCES bico.tb_profissional_cargo_pkey(id)
);

