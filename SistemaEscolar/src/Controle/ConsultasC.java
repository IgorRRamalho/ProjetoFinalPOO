package Controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.cj.protocol.Resultset;

public class ConsultasC {
    private String nomeCurso;
    private String turno;
    private String dataCriacao;
    private int notaMec;
    private int quantSemestres;
    private int minEducacaoId;
    private String anoAltGrade;
    private int tcc;
    private int creditos;
    private int horasComplementares;

    private String nomeMateria;
    
    BancoDeDados bancoDeDados = new BancoDeDados();

    void ConsultaCursoPorID(ResultSet base) throws SQLException, ParseException {
        System.out.println("============== Curso ==============");
        if (base.next()) { // Move the cursor to the first row
            int idcurso = base.getInt(1);
            nomeCurso = base.getString(2);
            turno = base.getString(3);
            dataCriacao = base.getString(4);
            notaMec = base.getInt(5);
            quantSemestres = base.getInt(6);
            minEducacaoId = base.getInt(7);
            anoAltGrade = base.getString(8);
            tcc = base.getInt(9);
            creditos = base.getInt(10);
            horasComplementares = base.getInt(11);
            String Materias = base.getString(12);

            System.out.println("ID do Curso: " + idcurso);
            System.out.println("Nome do Curso: " + nomeCurso);
            System.out.println("Turno: " + turno);

            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(dataCriacao);
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dt);
            System.out.println("Data Criação: " + dataFormatada);
            System.out.println("Nota MEC: " + notaMec);
            System.out.println("Quantidade de Semestres: " + quantSemestres);
            System.out.println("ID do Ministério da Educação: " + minEducacaoId);
            System.out.println("TCC: " + tcc);
            System.out.println("Créditos do Curso: " + creditos);
            System.out.println("Horas Complementares: " + horasComplementares);
            System.out.println("Matérias do Curso: " + Materias);
            bancoDeDados.fecharConexao();

        } else {
            System.out.println("Não foram encontrados cursos com esse ID");
        }
    }

    void ConsultaMateria(ResultSet base) throws SQLException, ParseException {
        System.out.println("============== Materias ==============");
        if (base.next()) { // Move the cursor to the first row

            int idMateria = base.getInt(1);
            String nomeMateria = base.getString(2);

            System.out.println("ID da Materia: " + idMateria);
            System.out.println("Nome da Materia: " + nomeMateria);
            bancoDeDados.fecharConexao();

            while (base.next()) {
                int id = base.getInt("id");
                String nome = base.getString("nome");
                System.out.println("ID: " + id + ", Nome: " + nome);
            }

        } else {
            System.out.println("Não foram encontradas matérias com este nome.");
        }
    }


      void ConsultaHistorico(ResultSet base) throws SQLException, ParseException {
        System.out.println("============== Historico ==============");
        if (base.next()) { // Move the cursor to the first row

            int idAluno = base.getInt(1);
            String nomeAluno = base.getString(2);
            String nomeMateria = base.getString(3);
            Float prova1 = base.getFloat(4);
            Float prova2 = base.getFloat(5);
            int faltas = base.getInt(6);

            System.out.println("ID do Aluno: " + idAluno);
            System.out.println("Nome do Aluno: " + nomeAluno);
            System.out.println("Nome da Materia: " + nomeMateria);
            System.out.println("Nota P1: " + prova1);
            System.out.println("Nota P2: " + prova2);
            System.out.println("Faltas: " + faltas);
            bancoDeDados.fecharConexao();


        } else {
            System.out.println("Não foi encontrado hitórico com este ID.");
        }
    }

    //id nome rg cpf nasc sex email cel pai mae historicoEM resevista comp_resd coleg anti  eja ensi_tec rua bairro num compl cep cidaDWE ESTADO

    void ConsultaDPessoais(ResultSet base) throws SQLException, ParseException {
        System.out.println("============== Dados Pessoais ==============");
        if (base.next()) { // Move the cursor to the first row

            int idAluno = base.getInt(1);
            String nomeAluno = base.getString(2);
            int rg = base.getInt(3);
            String cpf = base.getString(4);
            String data_nasc = 



            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(dataCriacao);
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dt);

            System.out.println("ID do Aluno: " + idAluno);
            System.out.println("Nome do Aluno: " + nomeAluno);
            System.out.println("Nome da Materia: " + nomeMateria);
            System.out.println("Nota P1: " + prova1);
            System.out.println("Nota P2: " + prova2);
            System.out.println("Faltas: " + faltas);
            bancoDeDados.fecharConexao();


        } else {
            System.out.println("Não foi encontrado hitórico com este ID.");
        }
    }
}