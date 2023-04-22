CREATE TABLE bico.tb_usuario (
	id uuid NOT NULL,
	nome varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	senha varchar(80) NOT NULL,
	profissoes varchar(100) NULL,
  telefone varchar(100) NULL,
  latitude varchar(100) NULL,
  longitude varchar(100) NULL,
  endereco varchar(100) NULL,
  verificated_at timestamp NULL,
	CONSTRAINT tb_usuario_pkey PRIMARY KEY (id)
);

CREATE TABLE bico.tb_servico (
	id uuid NOT NULL,
    nome varchar(50) NOT NULL,
	categoria varchar(50) NOT NULL,
	CONSTRAINT tb_servico_pkey PRIMARY KEY (id)
);

CREATE TABLE bico.tb_usuario_servicos (
  id uuid PRIMARY KEY,
  usuario_id uuid REFERENCES tb_usuario(id),
  servico_id uuid REFERENCES tb_servico(id),
  UNIQUE(usuario_id, servico_id)
);
