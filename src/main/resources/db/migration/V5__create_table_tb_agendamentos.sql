CREATE TABLE tb_agendamentos(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    fk_medico BIGINT,
    fk_paciente BIGINT,
    data_criacao DATE NOT NULL,
    data_agendada DATE NOT NULL,
    hora_agendada TIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    especialidade VARCHAR(50) NOT NULL,

    FOREIGN KEY (fk_medico) REFERENCES tb_usuarios(id),
    FOREIGN KEY (fk_paciente) REFERENCES tb_usuarios(id)
);
