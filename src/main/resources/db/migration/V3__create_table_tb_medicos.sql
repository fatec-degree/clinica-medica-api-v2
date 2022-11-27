CREATE TABLE tb_medicos (
    id BIGINT,
    crm VARCHAR(15) NOT NULL,
    especialidade VARCHAR(50) NOT NULL,

    FOREIGN KEY (id) REFERENCES tb_usuarios(id)
);
