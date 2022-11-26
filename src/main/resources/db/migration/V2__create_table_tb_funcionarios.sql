CREATE TABLE tb_funcionarios (
    id BIGINT,
    setor VARCHAR(50) NOT NULL,
    ativo BOOL NOT NULL,

    FOREIGN KEY (id) REFERENCES tb_usuarios(id)
);
