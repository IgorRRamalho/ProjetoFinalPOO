package Controle;

import Modelo.AlunoM;

import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;




public class AlunoC{

    BancoDeDados db = new BancoDeDados();
    String sql;
    ResultSet dados;


    public void CadastroAluno(String nome, String nomePai, String nomeMae, String rg, String cpf, String dataNasc, String email, char sexo, String celular){


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatter.parse(dataNasc);

        AlunoM a = new AlunoM(nome, nomePai, nomeMae, rg, cpf, dataNasc, email, sexo, celular );

        
        
        try {

            db.abrirConexao();
            sql="insert into curso values('"+.()+"', '"+curso.getNome()+"', '"+curso.getTurno()+"')";
            db.getStatement().execute(sql);
            db.fecharConexao();
            
        } catch (Exception erro) {
            erro.printStackTrace();
        
        }

        
    }

}
