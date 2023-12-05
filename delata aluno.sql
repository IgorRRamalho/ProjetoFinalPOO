-- Desativa chaves estrangeiras temporariamente para permitir a exclusão em cascata
SET FOREIGN_KEY_CHECKS = 0;

-- Exclui registros relacionados em dados_academicos
DELETE FROM dados_academicos WHERE aluno_id = [aluno_id];

-- Exclui registros relacionados em origem
DELETE FROM origem WHERE aluno_id = [aluno_id];

-- Exclui registros relacionados em endereco
DELETE FROM endereco WHERE aluno_id = [aluno_id];

-- Exclui registros relacionados em parcelas
DELETE FROM parcelas WHERE aluno_id = [aluno_id];

-- Exclui registros relacionados em historico
DELETE FROM historico WHERE aluno_id = [aluno_id];

-- Exclui registros relacionados em doc_pagamento
DELETE FROM doc_pagamento WHERE doc_id IN (SELECT doc_id FROM parcelas WHERE aluno_id = [aluno_id]);

-- Exclui o aluno
DELETE FROM aluno WHERE aluno_id = [aluno_id];

-- Restaura a verificação de chaves estrangeiras
SET FOREIGN_KEY_CHECKS = 1;
