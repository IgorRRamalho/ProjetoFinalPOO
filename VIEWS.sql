-- Consultar todas as matérias
CREATE VIEW view_todas_materias AS
SELECT * FROM materias;

-- Consultar aluno por ID
CREATE VIEW view_aluno_por_id AS
SELECT * FROM aluno WHERE aluno_id = [ID_DO_ALUNO];

-- Consultar dados pessoais do aluno, como origem e endereço
CREATE VIEW view_dados_pessoais_aluno AS
SELECT a.aluno_id, a.nome, a.nome_pai, a.nome_mae, o.historico_em, o.reservista, o.comp_residencia,
       e.rua, e.bairro, e.numero, e.complemento, e.cep, e.cidade, e.estado
FROM aluno a
LEFT JOIN origem o ON a.aluno_id = o.aluno_id
LEFT JOIN endereco e ON a.aluno_id = e.aluno_id;

-- Consultar todos os cursos
CREATE VIEW view_todos_cursos AS
SELECT * FROM curso;

-- Consultar curso por ID
CREATE VIEW view_curso_por_id AS
SELECT * FROM curso WHERE curso_id = [ID_DO_CURSO];

-- Consultar alunos de um curso por ID do curso
CREATE VIEW view_alunos_por_curso AS
SELECT a.*
FROM aluno a
JOIN dados_academicos d ON a.aluno_id = d.aluno_id
WHERE d.curso_id = [ID_DO_CURSO];

-- Consultar dados acadêmicos (notas e faltas) de um aluno em uma matéria por ID da matéria
CREATE VIEW view_dados_academicos_por_materia AS
SELECT a.aluno_id, a.nome, m.nome_materia, h.Prova1, h.Prova2, h.faltas
FROM aluno a
JOIN historico h ON a.aluno_id = h.aluno_id
JOIN materias m ON h.materia_id = m.materia_id
WHERE h.materia_id = [ID_DA_MATERIA];

-- Consultar dados acadêmicos (notas e faltas) de um aluno em todas as matérias
CREATE VIEW view_dados_academicos_todas_materias AS
SELECT a.aluno_id, a.nome, m.nome_materia, h.Prova1, h.Prova2, h.faltas
FROM aluno a
JOIN historico h ON a.aluno_id = h.aluno_id
JOIN materias m ON h.materia_id = m.materia_id;






--------------------------------------------------------------------------------
-- Consultar todas as matérias
SELECT * FROM view_todas_materias;

-- Consultar aluno por ID
SELECT * FROM view_aluno_por_id;

-- Consultar dados pessoais do aluno, como origem e endereço
SELECT * FROM view_dados_pessoais_aluno;

-- Consultar todos os cursos
SELECT * FROM view_todos_cursos;

-- Consultar curso por ID
SELECT * FROM view_curso_por_id;

-- Consultar alunos de um curso por ID do curso
SELECT * FROM view_alunos_por_curso;

-- Consultar dados acadêmicos (notas e faltas) de um aluno em uma matéria por ID da matéria
SELECT * FROM view_dados_academicos_por_materia;

-- Consultar dados acadêmicos (notas e faltas) de um aluno em todas as matérias
SELECT * FROM view_dados_academicos_todas_materias;


--------------------------------------------------------------------------------

-- Consultar aluno por ID (substitua [SEU_ALUNO_ID] pelo ID desejado)
SELECT * FROM view_aluno_por_id WHERE aluno_id = [SEU_ALUNO_ID];

-- Consultar curso por ID (substitua [SEU_CURSO_ID] pelo ID desejado)
SELECT * FROM view_curso_por_id WHERE curso_id = [SEU_CURSO_ID];

-- Consultar alunos de um curso por ID do curso (substitua [SEU_CURSO_ID] pelo ID desejado)
SELECT * FROM view_alunos_por_curso WHERE curso_id = [SEU_CURSO_ID];

-- Consultar dados acadêmicos (notas e faltas) de um aluno em uma matéria por ID da matéria e aluno_id (substitua [SEU_ALUNO_ID] e [SUA_MATERIA_ID] pelos IDs desejados)
SELECT * FROM view_dados_academicos_por_materia WHERE aluno_id = [SEU_ALUNO_ID] AND materia_id = [SUA_MATERIA_ID];
