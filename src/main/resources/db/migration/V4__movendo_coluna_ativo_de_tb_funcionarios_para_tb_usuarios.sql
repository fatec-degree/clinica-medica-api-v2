ALTER TABLE tb_funcionarios DROP COLUMN ativo;
ALTER TABLE tb_usuarios ADD COLUMN ativo BOOL NOT NULL;
UPDATE tb_usuarios SET ativo = 1;
