package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {
    private Connection conexao;
    private Statement statement;
    public void abrirConexao() {
        try {
            // Carregue o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabeleça a conexão com o MySQL
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hml", "root", "*Igor1010*");

            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Falha ao tentar a conexão");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conexao;
    }

    public Statement getStatement() {
        return statement;
    }

    public void fecharConexao() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
