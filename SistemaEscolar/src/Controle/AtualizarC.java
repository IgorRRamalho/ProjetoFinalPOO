package Controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A classe AtualizarC contém métodos para realizar operações de atualização no banco de dados,
 * como modificar situação de pagamento, notas, faltas, origem e colégio antigo de alunos.
 *
 * @author Giovanna Serejo
 */
public class AtualizarC {

    /**
     * Atualiza a situação de pagamento de um aluno para um determinado ano/mês.
     *
     * @param anomes   O ano/mês a ser atualizado.
     * @param idaluno  O ID do aluno.
     * @param sit      A nova situação de pagamento.
     */
    public void AtualizarSitPag(String anomes, int idaluno, byte sit) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            // Prepara a chamada do procedimento armazenado no banco de dados
            String query = "CALL AlterarSitPag(?, ?, ?)";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, idaluno);
            preparedStatement.setString(2, anomes);
            preparedStatement.setByte(3, sit);

            // Executa a atualização no banco de dados
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utilitarios.limparTelaConsole();
            bancoDeDados.fecharConexao();
        }
    }

    /**
     * Atualiza a nota da primeira prova de um aluno em uma matéria específica.
     *
     * @param alunoId     O ID do aluno.
     * @param materiaId   O ID da matéria.
     * @param novaNota    A nova nota da prova 1.
     */
    public void AtualizarNotaProva1(int alunoId, int materiaId, float novaNota) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            // Prepara a chamada do procedimento armazenado no banco de dados
            String query = "CALL AtualizarNotaProva1(?, ?, ?)";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, alunoId);
            preparedStatement.setInt(2, materiaId);
            preparedStatement.setFloat(3, novaNota);

            // Executa a atualização no banco de dados
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utilitarios.limparTelaConsole();
            bancoDeDados.fecharConexao();
        }
    }

    /**
     * Atualiza a nota da segunda prova de um aluno em uma matéria específica.
     *
     * @param alunoId     O ID do aluno.
     * @param materiaId   O ID da matéria.
     * @param novaNota    A nova nota da prova 2.
     */
    public void AtualizarNotaProva2(int alunoId, int materiaId, float novaNota) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            // Prepara a chamada do procedimento armazenado no banco de dados
            String query = "CALL AtualizarNotaProva2(?, ?, ?)";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, alunoId);
            preparedStatement.setInt(2, materiaId);
            preparedStatement.setFloat(3, novaNota);

            // Executa a atualização no banco de dados
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utilitarios.limparTelaConsole();
            bancoDeDados.fecharConexao();
        }
    }

    /**
     * Atualiza o número de faltas de um aluno em uma matéria específica.
     *
     * @param alunoId      O ID do aluno.
     * @param materiaId    O ID da matéria.
     * @param novasFaltas  O novo número de faltas.
     */
    public void AtualizarNumeroFaltas(int alunoId, int materiaId, int novasFaltas) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            // Prepara a chamada do procedimento armazenado no banco de dados
            String query = "CALL AtualizarNumeroFaltas(?, ?, ?)";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, alunoId);
            preparedStatement.setInt(2, materiaId);
            preparedStatement.setInt(3, novasFaltas);

            // Executa a atualização no banco de dados
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utilitarios.limparTelaConsole();
            bancoDeDados.fecharConexao();
        }
    }

    /**
     * Atualiza a origem de um aluno em uma coluna específica.
     *
     * @param alunoId     O ID do aluno.
     * @param coluna      O nome da coluna a ser atualizada.
     * @param novoValor   O novo valor da origem.
     */
    public void AtualizarOrigem(int alunoId, String coluna, byte novoValor) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            // Prepara a chamada do procedimento armazenado no banco de dados
            String query = "CALL AtualizarOrigem(?, ?, ?)";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, alunoId);
            preparedStatement.setString(2, coluna);
            preparedStatement.setByte(3, novoValor);

            // Executa a atualização no banco de dados
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utilitarios.limparTelaConsole();
            bancoDeDados.fecharConexao();
        }
    }

    /**
     * Atualiza o colégio antigo de um aluno.
     *
     * @param alunoId            O ID do aluno.
     * @param novoColegioAntigo  O novo nome do colégio antigo.
     */
    public void AtualizarColegioAntigo(int alunoId, String novoColegioAntigo) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.abrirConexao();

        try {
            // Prepara a chamada do procedimento armazenado no banco de dados
            String query = "CALL AtualizarColegioAntigo(?, ?)";
            PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, alunoId);
            preparedStatement.setString(2, novoColegioAntigo);

            // Executa a atualização no banco de dados
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utilitarios.limparTelaConsole();
            bancoDeDados.fecharConexao();
        }
    }
}
