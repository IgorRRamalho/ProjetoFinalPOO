package Controle;

import Modelo.*;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CursoC {

    BancoDeDados db = new BancoDeDados();
    String sql;
    ResultSet dados;

    public void CadastroAluno(AlunoM aluno) {
        try {
            db.abrirConexao();

            String sql = "INSERT INTO hml.aluno(nome, nome_pai, nome_mae, rg, cpf, data_nasc, email, sexo, celular) " +
                    "VALUES('" + aluno.getNome() + "', '" + aluno.getNomePai() + "', '" + aluno.getNomeMae() + "', " +
                    "'" + aluno.getRg() + "', '" + aluno.getCpf() + "', '" + aluno.getDataNasc() + "', " +
                    "'" + aluno.getEmail() + "', '" + aluno.getSexo() + "', '" + aluno.getCelular() + "')";

            db.getStatement().execute(sql);
            db.fecharConexao();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    public void AtualizaNomeDoCurso(String nome, int codigo) {
        try {

            db.abrirConexao();
            sql = "update curso set nome='" + nome + "' where codigo='" + codigo + "'";
            db.getStatement().execute(sql);
            db.fecharConexao();
            System.out.println("UPDATE OK!");

        } catch (Exception erro) {
            erro.printStackTrace();
            System.out.println("ERRO NO UPDATE");

        }

    }

    public ResultSet ConsultaGeral() {
        BancoDeDados db = new BancoDeDados();
        String sql;

        try {
            db.abrirConexao();
            sql = "SELECT * FROM curso";
            ResultSet dados = db.getStatement().executeQuery(sql);
            return dados;

        } catch (Exception erro) {
            erro.printStackTrace();
        }
        db.fecharConexao();
        return null;
    }

    public ResultSet ConsultaPorCodigo(int codigo) {
        BancoDeDados db = new BancoDeDados();
        String sql;

        try {
            db.abrirConexao();
            String sql = "select * from curso where codigo-'" + codigo + "'";
            ResultSet dados = db.getStatement().executeQuery(sql);
            return dados;

        } catch (Exception erro) {
            erro.printStackTrace();
        }
        db.fecharConexao();
        return null;
    }

    public ResultSet ConsultaOrdenadaPorNome() {
        BancoDeDados db = new BancoDeDados();

        try {
            db.abrirConexao();
            String sql = "select * from curso order by nome";
            ResultSet dados = db.getStatement().executeQuery(sql);
            return dados;

        } catch (Exception erro) {
            erro.printStackTrace();
        }
        db.fecharConexao();
        return null;
    }

    public void ImprimirConsulta(ResultSet base) {

        try {
            while (base.next()) {
                System.out.println("---------------------------------------------");
                System.out.println("CÓDIGO: " + base.getInt("codigo"));
                System.out.println("NOME: " + base.getString("nome"));
                System.out.println("TURNO: " + base.getString("turno"));
            }

        } catch (Exception erro) {
            erro.printStackTrace();
        }

    }

}
