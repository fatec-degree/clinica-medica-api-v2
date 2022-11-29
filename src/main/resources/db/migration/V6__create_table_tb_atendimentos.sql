CREATE TABLE tb_atendimentos(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fk_agendamento BIGINT,
    descricao VARCHAR(255) NOT NULL,
    data_criacao DATE NOT NULL,

    FOREIGN KEY (fk_agendamento) REFERENCES tb_agendamentos(id)
);
