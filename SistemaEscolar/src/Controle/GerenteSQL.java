package Controle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Modelo.AlunoM;
import Modelo.CursoM;
import Modelo.GradeCursoM;
import Modelo.MateriasM;

/**
 * Interface para operações SQL genéricas em modelos específicos.
 *
 * @param <Modelo> Tipo do modelo associado à operação SQL.
 */
public interface GerenteSQL<Modelo> {
    void InserirSQL(Modelo objeto);

    void RemoverSQL(int ID);

    ResultSet ConsultarSQL(int ID, String query);

    /**
     * Implementação da interface GerenteSQL para operações relacionadas a Cursos.
     */
    public class Curso implements GerenteSQL<CursoM> {

        /**
         * Insere um novo curso no banco de dados.
         *
         * @param curso Curso a ser inserido.
         */
        @Override
        public void InserirSQL(CursoM curso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO hml.curso (nome_curso, turno, data_criacao, nota_mec, quant_semestres, min_educacao_id, ano_alt_grade, tcc, creditos, horas_complementares)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, curso.getNomeCurso());
                preparedStatement.setString(2, curso.getTurno());

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(curso.getDataCriacao());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                preparedStatement.setDate(3, sqlDate);
                preparedStatement.setInt(4, curso.getNotaMec());
                preparedStatement.setInt(5, curso.getQuantSemestres());
                preparedStatement.setInt(6, curso.getMinEducacaoId());
                preparedStatement.setString(7, curso.getAnoAltGrade());
                preparedStatement.setInt(8, curso.getTcc());
                preparedStatement.setInt(9, curso.getCreditos());
                preparedStatement.setInt(10, curso.getHorasComplementares());

                preparedStatement.executeUpdate();

            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
            }
        }

        /**
         * Remove um curso do banco de dados.
         *
         * @param idCurso Identificador do curso a ser removido.
         */
        @Override
        public void RemoverSQL(int idCurso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "CALL ExcluirCurso(?);";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idCurso);

                preparedStatement.executeUpdate();
                Utilitarios.limparTelaConsole();
            } catch (SQLException e) {
                e.printStackTrace();
                Utilitarios.limparTelaConsole();
                System.out.println("*** Não é possível excluir o curso. Existem alunos vinculados a ele ***");
            } finally {
                bancoDeDados.fecharConexao();
            }
        }

        /**
         * Consulta informações de um curso no banco de dados.
         *
         * @param idCurso Identificador do curso a ser consultado.
         * @param query   Consulta SQL a ser executada.
         * @return Resultado da consulta.
         */
        @Override
        public ResultSet ConsultarSQL(int idCurso, String query) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();
            ResultSet resultado = null;
            try {

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idCurso);

                resultado = preparedStatement.executeQuery();
                return resultado;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return resultado;
            }
        }
    }

    /**
     * Implementação da interface GerenteSQL para operações relacionadas a Matérias.
     */
    public class Materias implements GerenteSQL<MateriasM> {

        /**
         * Insere uma nova matéria no banco de dados.
         *
         * @param materia Matéria a ser inserida.
         */
        @Override
        public void InserirSQL(MateriasM materia) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO hml.materias (nome_materia) "
                        + "VALUES(?);";

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, materia.getNomeMateria());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
            }
        }

        /**
         * Remove uma matéria do banco de dados.
         *
         * @param materiaId Identificador da matéria a ser removida.
         */
        @Override
        public void RemoverSQL(int materiaId) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "CALL ExcluirDisciplina(?);";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, materiaId);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Consulta informações de matérias no banco de dados.
         *
         * @param ID    Identificador (não utilizado neste contexto).
         * @param query Consulta SQL a ser executada.
         * @return Resultado da consulta.
         */
        @Override
        public ResultSet ConsultarSQL(int ID, String query) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            ResultSet resultado = null;
            bancoDeDados.abrirConexao();

            try {
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                resultado = preparedStatement.executeQuery();
                return resultado;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return resultado;
            }

        }
    }

    /**
     * Implementação da interface GerenteSQL para operações relacionadas a Alunos.
     */
    public class Aluno implements GerenteSQL<AlunoM> {

        /**
         * Insere um novo aluno no banco de dados.
         *
         * @param aluno Aluno a ser inserido.
         */
        @Override
        public void InserirSQL(AlunoM aluno) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();
            System.out.println("ID do Curso: " + aluno.getIDcurso());

            try {
                String query = "{ CALL hml.cadastrar_aluno(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";

                try (CallableStatement callableStatement = bancoDeDados.getConnection().prepareCall(query)) {
                    callableStatement.setString(1, aluno.getNome());
                    callableStatement.setString(2, aluno.getNomePai());
                    callableStatement.setString(3, aluno.getNomeMae());
                    callableStatement.setString(4, aluno.getRg());
                    callableStatement.setString(5, aluno.getCpf());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = dateFormat.parse(aluno.getDataNasc());
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    callableStatement.setDate(6, sqlDate);
                    callableStatement.setString(7, aluno.getEmail());
                    callableStatement.setString(8, String.valueOf(aluno.getSexo()));
                    callableStatement.setString(9, aluno.getCelular());

                    callableStatement.setString(10, aluno.getRua());
                    callableStatement.setString(11, aluno.getBairro());
                    callableStatement.setInt(12, aluno.getNumero());
                    callableStatement.setString(13, aluno.getComplemento());
                    callableStatement.setString(14, aluno.getCep());
                    callableStatement.setString(15, aluno.getCidade());
                    callableStatement.setString(16, aluno.getEstado());
                    callableStatement.setInt(17, aluno.getIDcurso());

                    callableStatement.registerOutParameter(18, Types.INTEGER);

                    callableStatement.execute();

                    int alunoIdOut = callableStatement.getInt(18);
                    System.out.println("Aluno ID: " + alunoIdOut);
                }

            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
                Utilitarios.limparTelaConsole();
            }
        }

        /**
         * Remove um aluno do banco de dados.
         *
         * @param idAluno Identificador do aluno a ser removido.
         */
        @Override
        public void RemoverSQL(int idAluno) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            try {
                String query = "CALL ExcluirAluno(?);";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idAluno);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Consulta informações de alunos no banco de dados.
         *
         * @param ID    Identificador do aluno a ser consultado.
         * @param query Consulta SQL a ser executada.
         * @return Resultado da consulta.
         */
        @Override
        public ResultSet ConsultarSQL(int ID, String query) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            ResultSet resultado = null;
            bancoDeDados.abrirConexao();

            try {
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, ID);
                resultado = preparedStatement.executeQuery();
                return resultado;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return resultado;
            }
        }
    }

    /**
     * Implementação adicional para operações relacionadas a Grade de Curso.
     */
    public class GradeCurso implements GerenteSQL<GradeCursoM> {

        /**
         * Insere uma nova entrada na grade de curso no banco de dados.
         *
         * @param grade Entrada de grade de curso a ser inserida.
         */
        @Override
        public void InserirSQL(GradeCursoM grade) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO grade_curso (curso_id, materia_id)"
                        + " VALUES(?, ?);";

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, grade.getCursoId());
                preparedStatement.setInt(2, grade.getMateriaId());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();

            }
        }

        /**
         * Remover uma entrada na grade de curso do banco de dados (não implementado).
         *
         * @param ID Identificador da entrada na grade de curso a ser removida.
         */
        @Override
        public void RemoverSQL(int ID) {
            throw new UnsupportedOperationException("Unimplemented method 'RemoverSQL'");
        }

        /**
         * Consultar informações na grade de curso do banco de dados (não implementado).
         *
         * @param ID    Identificador da entrada na grade de curso a ser consultada.
         * @param query Consulta SQL a ser executada.
         * @return Resultado da consulta.
         */
        @Override
        public ResultSet ConsultarSQL(int ID, String query) {
            throw new UnsupportedOperationException("Unimplemented method 'ConsultarSQL'");
        }
    }
}
