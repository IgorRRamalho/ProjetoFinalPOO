package Controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.AlunoM;

public class Utilitarios {

    public void limparTelaConsole() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    public int getIDaluno(String palavra) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();
        int idaluno = 0;

        try {
            String query = "SELECT a.aluno_id FROM aluno a WHERE a.cpf = ?";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setString(1, palavra);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Move the cursor to the first row
            if (resultSet.next()) {
                // Retrieve the value of "aluno_id" from the current row
                idaluno = resultSet.getInt("aluno_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bancoDeDados.fecharConexao();
        }
        return idaluno;
    }

    public int getIDcurso(String palavra) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();
        int cursoid = 0;

        try {
            String query = "SELECT a.curso_id FROM curso a WHERE a.nome_curso = ?";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setString(1, palavra);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Move the cursor to the first row
            if (resultSet.next()) {
                // Retrieve the value of "aluno_id" from the current row
                cursoid = resultSet.getInt("curso_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bancoDeDados.fecharConexao();
        }
        return cursoid;
    }


    public int verificaIDcurso(int idcurso) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();
        int resul = 0;

        try {
            String query = "SELECT 1 FROM curso WHERE id_curso = ?";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, idcurso);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Verifica se há linhas no resultado
                if (resultSet.next()) {
                    // O curso existe, resultSet.getInt(1) retornará 1
                    resul = 1;

                } else {
                    // O curso não existe
                    System.out.println("Existe Curso: 0");
                    resul = 0;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bancoDeDados.fecharConexao();
        }
        return resul;

    }


    public int verificaIDMaterias(int materia_id) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();
        int resul = 0;

        try {
            String query = "SELECT 1 FROM materias WHERE materia_id = ?";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, materia_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Verifica se há linhas no resultado
                if (resultSet.next()) {
                    // O curso existe, resultSet.getInt(1) retornará 1
                    resul = 1;

                } else {
                    // O curso não existe
                    System.out.println("Existe Materia: 0");
                    resul = 0;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bancoDeDados.fecharConexao();
        }
        return resul;

    }

}
