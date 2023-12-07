package Controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


/**
 * A classe Utilitarios fornece métodos utilitários para operações com o banco de dados e outras funcionalidades.
 * 
 * @author Iury Gabriel
 * @version 1.0
 */
public class Utilitarios {

    /**
     * Limpa a tela do console.
     */
    public static void limparTelaConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * Obtém o ID de um aluno com base no CPF.
     * 
     * @param cpf O CPF do aluno.
     * @return O ID do aluno ou 0 se não encontrado.
     */
    public int getIDaluno(String cpf) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();
        int idAluno = 0;

        try {
            String query = "SELECT aluno_id FROM aluno WHERE cpf = ?";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setString(1, cpf);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idAluno = resultSet.getInt("aluno_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bancoDeDados.fecharConexao();
        }
        return idAluno;
    }

    /**
     * Obtém o ID de um curso com base no nome do curso.
     * 
     * @param nomeCurso O nome do curso.
     * @return O ID do curso ou 0 se não encontrado.
     */
    public int getIDcurso(String nomeCurso) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();
        int cursoId = 0;

        try {
            String query = "SELECT curso_id FROM hml.curso WHERE nome_curso = ?";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setString(1, nomeCurso);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cursoId = resultSet.getInt("curso_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bancoDeDados.fecharConexao();
        }
        return cursoId;
    }

    /**
     * Verifica se um ID de curso é válido.
     * 
     * @param idCurso O ID do curso a ser verificado.
     * @return true se o ID de curso é válido, false caso contrário.
     */
    public boolean verificaIDcurso(int idCurso) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            String query = "call VerificarCurso(?, ?)";
            java.sql.CallableStatement callableStatement = bancoDeDados.getConnection().prepareCall(query);
            callableStatement.setInt(1, idCurso);
            callableStatement.registerOutParameter(2, Types.BOOLEAN);
            callableStatement.execute();

            return callableStatement.getBoolean(2);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            bancoDeDados.fecharConexao();
        }
    }

    /**
     * Verifica se um ID de matéria é válido.
     * 
     * @param materiaId O ID da matéria a ser verificado.
     * @return 1 se o ID de matéria é válido, 0 caso contrário.
     */
    public int verificaIDMaterias(int materiaId) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();
        int resultado = 0;

        try {
            String query = "SELECT 1 FROM materias WHERE materia_id = ?";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, materiaId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    resultado = 1;
                } else {
                    resultado = 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bancoDeDados.fecharConexao();
        }
        return resultado;
    }

    /**
     * Verifica se um ID de aluno é válido.
     * 
     * @param idAluno O ID do aluno a ser verificado.
     * @return true se o ID de aluno é válido, false caso contrário.
     */
    public boolean verificaIDaluno(int idAluno) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            String query = "{call VerificarAluno(?, ?)}";
            java.sql.CallableStatement callableStatement = bancoDeDados.getConnection().prepareCall(query);
            callableStatement.setInt(1, idAluno);
            callableStatement.registerOutParameter(2, Types.BOOLEAN);
            callableStatement.execute();

            return callableStatement.getBoolean(2);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            bancoDeDados.fecharConexao();
        }
    }
}
