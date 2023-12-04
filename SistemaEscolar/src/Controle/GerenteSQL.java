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
    void InserirSQL(Modelo objeto);

    void RemoverSQL(int ID);

    void AtualizarSQL(Modelo objeto, int IDaluno);

    ResultSet ConsultarSQL(int ID);

    Materias MateriasC = new Materias();
    Curso CursoC = new Curso();
    Aluno AlunoC = new Aluno();
    Utilitarios util = new Utilitarios();

    public class Curso implements GerenteSQL<CursoM> {

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

            try {
                String query = "DELETE FROM curso WHERE curso_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idCurso);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void AtualizarSQL(CursoM objeto, int IDaluno) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'AtualizarSQL'");
        }

        @Override
        public ResultSet ConsultarSQL(int idCurso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            try {
                String query = "SELECT * FROM grade_curso WHERE curso_id = ? AND materia_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idCurso);
             

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Aqui você pode recuperar e exibir os dados da grade_curso conforme
                    // necessário.
                    int cursoId = resultSet.getInt("curso_id");
                    int materiaId = resultSet.getInt("materia_id");

                    System.out.println("Curso ID: " + cursoId + ", Matéria ID: " + materiaId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public class Materias implements GerenteSQL<MateriasM> {

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

        @Override
        public void RemoverSQL(int materiaId) {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "DELETE FROM curso WHERE materia_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, materiaId);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void AtualizarSQL(MateriasM objeto, int IDaluno) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'AtualizarSQL'");
        }

    }

    public class Aluno implements GerenteSQL<AlunoM> {

        @Override
        public void InserirSQL(AlunoM aluno) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO aluno(nome, nome_pai, nome_mae, rg, cpf, data_nasc, email, sexo, celular)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

                preparedStatement.executeUpdate();
                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();

                query = "INSERT INTO endereco (aluno_id, rua, bairro, numero, complemento, cep, cidade, estado) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = bancoDeDados.getConnection().prepareStatement(query);

                preparedStatement.setInt(1, util.getIDaluno(aluno.getCpf()));
                preparedStatement.setString(2, aluno.getRua());
                preparedStatement.setString(3, aluno.getBairro());
                preparedStatement.setInt(4, aluno.getNumero());
                preparedStatement.setString(5, aluno.getComplemento());
                preparedStatement.setString(6, aluno.getCep());
                preparedStatement.setString(7, aluno.getCidade());
                preparedStatement.setString(8, aluno.getEstado());

                preparedStatement.executeUpdate();

                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();

                query = "INSERT INTO dados_academicos(aluno_id, curso_id)"
                        + "VALUES(?, ?);";
                preparedStatement = bancoDeDados.getConnection().prepareStatement(query);

                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, aluno.getIDcurso());
                preparedStatement.executeUpdate();

                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();
                query = "CALL inserir_historico(?);";

                preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, util.getIDaluno(aluno.getCpf()));
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
                String query = "UPDATE aluno SET sit_aluno=b'0' WHERE aluno_id=?;";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idaluno);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void AtualizarSQL(AlunoM aluno, int IDaluno) {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "UPDATE aluno SET nome = ?, nome_pai = ?, nome_mae = ?, rg = ?, cpf = ?, " +
                        "data_nasc = ?, email = ?, sexo = ?, celular = ? WHERE aluno_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, aluno.getNome());
                preparedStatement.setString(2, aluno.getNomePai());
                preparedStatement.setString(3, aluno.getNomeMae());
                preparedStatement.setString(4, aluno.getRg());
                preparedStatement.setString(5, aluno.getCpf());
                preparedStatement.setString(6, aluno.getDataNasc());
                preparedStatement.setString(7, aluno.getEmail());
                preparedStatement.setString(8, String.valueOf(aluno.getSexo()));
                preparedStatement.setString(9, aluno.getCelular());
                preparedStatement.setInt(10, IDaluno);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}