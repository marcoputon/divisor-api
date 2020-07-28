CREATE TABLE produto (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	valor DECIMAL(8, 2) NOT NULL,
	CONSTRAINT produto_pk PRIMARY KEY (id)
)