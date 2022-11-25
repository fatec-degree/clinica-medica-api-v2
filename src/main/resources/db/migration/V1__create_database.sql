CREATE TABLE tb_usuarios(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario VARCHAR(50) NOT NULL
);

CREATE TABLE tb_pacientes(
    id BIGINT,
    cpf VARCHAR(15) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    contato VARCHAR(50),

    FOREIGN KEY (id) REFERENCES tb_usuarios(id)
);
