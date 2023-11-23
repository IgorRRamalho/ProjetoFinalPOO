package Controle;
import Modelo.*;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CursoC {

    BancoDeDados db = new BancoDeDados();
    String sql;
    ResultSet dados;


    public void CadastroCurso(String nomeCurso, String turno, String dataCriacao, int notaMec, int quantSemestres, 
    int minEducacaoId, String anoAltGrade, int tcc, int creditos, int horasComplementares, int semestres){


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatter.parse(dataCriacao);
       
       
        CursoM  a = new CursoM(nomeCurso, turno, data, notaMec, quantSemestres, minEducacaoId, anoAltGrade, tcc, creditos, horasComplementares, semestres);
        
        
        try {

            db.abrirConexao();
            sql="insert into curso values('"+curso.()+"', '"+curso.getNome()+"', '"+curso.getTurno()+"')";
            sql="INSERT INTO hml.curso
            (nome_curso, turno, data_criacao, nota_mec, quant_semestres, min_educacao_id, ano_alt_grade, tcc, creditos, horas_complementares, semestres)
            VALUES('"+a.get+"', '"+curso.getTurno()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"', '"+curso.getNomeCurso()+"');";
            db.getStatement().execute(sql);
            db.fecharConexao();
            
        } catch (Exception erro) {
            erro.printStackTrace();
        
        }

        
    }


    public void AtualizaNomeDoCurso(String nome, int codigo){
         try {

            db.abrirConexao();
            sql="update curso set nome='"+nome+"' where codigo='"+codigo+"'";
            db.getStatement().execute(sql);
            db.fecharConexao();
            System.out.println("UPDATE OK!");
            
            
        } catch (Exception erro) {
            erro.printStackTrace();
            System.out.println("ERRO NO UPDATE");
        
        }
    
    }

    public ResultSet ConsultaGeral(){
        BancoDeDados db= new BancoDeDados();
        String sql;

        try {
            db.abrirConexao();
            sql="SELECT * FROM curso";
            ResultSet dados =db.getStatement().executeQuery(sql);
            return dados;
            
        } catch (Exception erro) {
            erro.printStackTrace(); 
        }
        db.fecharConexao();
        return null;
    }

    public ResultSet ConsultaPorCodigo(int codigo){
        BancoDeDados db= new BancoDeDados();
        String sql;

        try {
            db.abrirConexao();
            String sql="select * from curso where codigo-'"+codigo+"'";
            ResultSet dados =db.getStatement().executeQuery(sql);
            return dados;
            
        } catch (Exception erro) {
            erro.printStackTrace(); 
        }
        db.fecharConexao();
        return null;
    }

    public ResultSet ConsultaOrdenadaPorNome(){
         BancoDeDados db= new BancoDeDados();
      
        try {
            db.abrirConexao();
            String sql="select * from curso order by nome";
            ResultSet dados =db.getStatement().executeQuery(sql);
            return dados;
            
        } catch (Exception erro) {
            erro.printStackTrace(); 
        }
        db.fecharConexao();
        return null;
    }


    public void ImprimirConsulta(ResultSet base){

        try {
            while(base.next()){
              System.out.println("---------------------------------------------");
              System.out.println("CÓDIGO: "+ base.getInt("codigo"));
              System.out.println("NOME: "+ base.getString("nome"));
              System.out.println("TURNO: "+ base.getString("turno"));
            }
    
          } catch (Exception erro) {
            erro.printStackTrace();
          }

    }
    
}
