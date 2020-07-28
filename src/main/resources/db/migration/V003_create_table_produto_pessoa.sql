CREATE TABLE produto_pessoa (
	id_produto BIGINT NOT NULL,
	id_pessoa BIGINT NOT NULL,
	CONSTRAINT produto_pessoa_pk PRIMARY KEY (id_produto,id_pessoa),
	CONSTRAINT produto_pessoa_fk FOREIGN KEY (id_pessoa) REFERENCES divisor.pessoa(id),
	CONSTRAINT produto_pessoa_fk_1 FOREIGN KEY (id_produto) REFERENCES divisor.produto(id)
)