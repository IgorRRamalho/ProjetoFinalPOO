package Controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Controle.GerenteGeral.Aluno;
import Controle.GerenteGeral.Materias;
import Modelo.AlunoM;
import Modelo.CursoM;
import Modelo.EnderecoM;
import Modelo.MateriasM;

public interface GerenteSQL<Modelo> {
    void InserirSQL(Modelo objeto, int id_curso);

    void RemoverSQL(int ID);

    ResultSet ConsultarSQL(int ID);

    Materias MateriasC = new Materias();
    Curso CursoC = new Curso();
    Aluno AlunoC = new Aluno();
    Utilitarios util = new Utilitarios();
    ConsultasC ConsultaC = new ConsultasC();

    public class Curso implements GerenteSQL<CursoM> {

        @Override
        public void InserirSQL(CursoM curso, int a) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO hml.curso (nome_curso, turno, data_criacao, nota_mec, quant_semestres, min_educacao_id, ano_alt_grade, tcc, creditos, horas_complementares)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, curso.getNomeCurso());
                preparedStatement.setString(2, curso.getTurno());

                // Convert the date to the 'YYYY-MM-DD' format
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
                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();

            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
            }
        }

        @Override
        public void RemoverSQL(int idCurso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "CALL ExcluirCurso(?);";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idCurso);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
            }
        }

        @Override
        public ResultSet ConsultarSQL(int idCurso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();
            ResultSet resultSet = null;
            try {
                String query = "";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idCurso);

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return resultSet;
            }
        }

    }

    public class Materias implements GerenteSQL<MateriasM> {

        @Override
        public void InserirSQL(MateriasM materia, int a) {
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

        @Override
        public void RemoverSQL(int materiaId) {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "CALL ExcluirDisciplina(?);";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, materiaId);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public ResultSet ConsultarSQL(int ID) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'ConsultarSQL'");
        }

    }

    public class Aluno implements GerenteSQL<AlunoM> {

        @Override
        public void InserirSQL(AlunoM aluno, int idcurso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = " CALL hml.cadastrar_aluno(? , ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? , ?, @aluno_id_out) ";

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, aluno.getNome());
                preparedStatement.setString(2, aluno.getNomePai());
                preparedStatement.setString(3, aluno.getNomeMae());
                preparedStatement.setString(4, aluno.getRg());
                preparedStatement.setString(5, aluno.getCpf());

                // Convert the date to the 'YYYY-MM-DD' format
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(aluno.getDataNasc());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                preparedStatement.setDate(6, sqlDate);
                preparedStatement.setString(7, aluno.getEmail());
                preparedStatement.setString(8, String.valueOf(aluno.getSexo()));
                preparedStatement.setString(9, aluno.getCelular());

                preparedStatement.setString(10, aluno.getRua());
                preparedStatement.setString(11, aluno.getBairro());
                preparedStatement.setInt(12, aluno.getNumero());
                preparedStatement.setString(13, aluno.getComplemento());
                preparedStatement.setString(14, aluno.getCep());
                preparedStatement.setString(15, aluno.getCidade());
                preparedStatement.setString(16, aluno.getEstado());
                preparedStatement.setInt(17, idcurso);
                preparedStatement.executeUpdate();

            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
                util.limparTelaConsole();
            }
        }

        @Override
        public void RemoverSQL(int idaluno) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            try {
                String query = "CALL ExcluirAluno(?);";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idaluno);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public ResultSet ConsultarSQL(int ID) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'ConsultarSQL'");
        }

    }

}
