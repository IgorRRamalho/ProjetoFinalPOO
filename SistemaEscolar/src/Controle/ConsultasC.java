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
            System.out.println("No rows found in the ResultSet.");
        }
    }
}
