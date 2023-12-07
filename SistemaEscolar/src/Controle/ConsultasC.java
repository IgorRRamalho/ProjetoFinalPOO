package Controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A classe ConsultasC contém métodos para realizar consultas no banco de dados relacionadas a cursos, matérias, histórico, dados pessoais, parcelas e alunos associados a um curso.
 */
public class ConsultasC {

    BancoDeDados bancoDeDados = new BancoDeDados();

    /**
     * Consulta informações de um curso por ID.
     *
     * @param base ResultSet contendo os resultados da consulta.
     * @throws SQLException
     * @throws ParseException
     */
    void ConsultaCursoPorID(ResultSet base) throws SQLException, ParseException {
        /**
         * Método que consulta e exibe informações detalhadas sobre um curso identificado pelo ID.
         *
         * @param base ResultSet contendo os resultados da consulta.
         * @throws SQLException em caso de erro na consulta SQL.
         * @throws ParseException em caso de erro na conversão de data.
         */
        if (base.next()) {
            int idcurso = base.getInt(1);
            String nomeCurso = base.getString(2);
            String turno = base.getString(3);
            Date dataCriacao = base.getDate(4);
            int notaMec = base.getInt(5);
            int quantSemestres = base.getInt(6);
            int minEducacaoId = base.getInt(7);
            String anoAltGrade = base.getString(8);
            int tcc = base.getInt(9);
            int creditos = base.getInt(10);
            int horasComplementares = base.getInt(11);
            String Materias = base.getString(12);

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|                            Informações do Curso                          |");
            System.out.println("----------------------------------------------------------------------------");
            System.out.printf("| %-40s | %-30s |%n", "ID do Curso:", idcurso);
            System.out.printf("| %-40s | %-30s |%n", "Nome do Curso:", nomeCurso);
            System.out.printf("| %-40s | %-30s |%n", "Turno:", turno);

            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataCriacao);
            System.out.printf("| %-40s | %-30s |%n", "Data Criação:", dataFormatada);
            System.out.printf("| %-40s | %-30s |%n", "Ano Altereção Grade:", anoAltGrade);

            System.out.printf("| %-40s | %-30s |%n", "Nota MEC:", notaMec);
            System.out.printf("| %-40s | %-30s |%n", "Quantidade de Semestres:", quantSemestres);
            System.out.printf("| %-40s | %-30s |%n", "ID do Ministério da Educação:", minEducacaoId);
            System.out.printf("| %-40s | %-30s |%n", "TCC:", tcc);
            System.out.printf("| %-40s | %-30s |%n", "Créditos do Curso:", creditos);
            System.out.printf("| %-40s | %-30s |%n", "Horas Complementares:", horasComplementares);
            System.out.printf("| %-40s | %-30s |%n", "Matérias do Curso:", Materias);
            System.out.println("-----------------------------------------------------------------------------");

            bancoDeDados.fecharConexao();

        } else {
            System.out.println("Não foram encontrados cursos com esse ID");
        }
    }

    /**
     * Consulta informações de matérias.
     *
     * @param base ResultSet contendo os resultados da consulta.
     * @throws SQLException
     */
    void ConsultaMateria(ResultSet base) throws SQLException {
        /**
         * Método que consulta e exibe informações sobre as matérias disponíveis.
         *
         * @param base ResultSet contendo os resultados da consulta.
         * @throws SQLException em caso de erro na consulta SQL.
         */
        System.out.println("============== Matérias ==============");

        while (base.next()) {
            int id = base.getInt(1);
            String nome = base.getString(2);
            System.out.println("ID: " + id + " - " + nome);
        }
        System.out.println("======================================");

        bancoDeDados.fecharConexao();
    }

    /**
     * Consulta histórico do aluno.
     *
     * @param base ResultSet contendo os resultados da consulta.
     * @throws SQLException
     * @throws ParseException
     */
    void ConsultaHistorico(ResultSet base) throws SQLException, ParseException {
        /**
         * Método que consulta e exibe o histórico acadêmico de um aluno.
         *
         * @param base ResultSet contendo os resultados da consulta.
         * @throws SQLException em caso de erro na consulta SQL.
         * @throws ParseException em caso de erro na conversão de data.
         */
        System.out.println("============== Histórico ==============");
        if (base.next()) {
            int idAluno = base.getInt(1);
            String nomeAluno = base.getString(2);
            String nomeMateria = base.getString(3);
            Float prova1 = base.getFloat(4);
            Float prova2 = base.getFloat(5);
            int faltas = base.getInt(6);

            System.out.println("ID do Aluno: " + idAluno);
            System.out.println("Nome do Aluno: " + nomeAluno);
            System.out.println("Nome da Matéria: " + nomeMateria);
            System.out.println("Nota P1: " + prova1);
            System.out.println("Nota P2: " + prova2);
            System.out.println("Faltas: " + faltas);

            bancoDeDados.fecharConexao();

        } else {
            System.out.println("Não foi encontrado histórico com este ID.");
        }
    }

    /**
     * Consulta dados pessoais do aluno.
     *
     * @param base ResultSet contendo os resultados da consulta.
     * @throws SQLException
     * @throws ParseException
     */
    void ConsultaDPessoais(ResultSet base) throws SQLException, ParseException {
        /**
         * Método que consulta e exibe informações pessoais e educacionais de um aluno.
         *
         * @param base ResultSet contendo os resultados da consulta.
         * @throws SQLException em caso de erro na consulta SQL.
         * @throws ParseException em caso de erro na conversão de data.
         */
        System.out.println("================== Dados Pessoais ==================\n");
        if (base.next()) {
            int idAluno = base.getInt(1);
            String nomeAluno = base.getString(2);
            int rg = base.getInt(3);
            String cpf = base.getString(4);
            String data_nasc = base.getString(5);
            String sexo = base.getString(6);
            String email = base.getString(7);
            String cel = base.getString(8);
            String nomePai = base.getString(9);
            String nomeMae = base.getString(10);
            String historicoEM = base.getString(11);
            String reservista = base.getString(12);
            String comp_resid = base.getString(13);
            String EJA = base.getString(14);
            String ens_Tec = base.getString(15);
            String colegio_antig = base.getString(16);

            String rua = base.getString(17);
            String bairro = base.getString(18);
            int num = base.getInt(19);
            String complemento = base.getString(20);
            String CEP = base.getString(21);
            String Cidade = base.getString(22);
            String estado = base.getString(23);

            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(data_nasc);
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dt);

            System.out.println("ID:                  " + idAluno);
            System.out.println("Nome do Aluno:       " + nomeAluno);
            System.out.println("RG:                  " + rg);
            System.out.println("CPF:                 " + cpf);
            System.out.println("Data de Nascimento:  " + dataFormatada);
            System.out.println("Sexo:                " + sexo);
            System.out.println("E-mail:              " + email);
            System.out.println("Celular:             " + cel);
            System.out.println("Nome do Pai:         " + nomePai);
            System.out.println("Nome da Mãe:         " + nomeMae);

            System.out.println("\n====================================================");
            System.out.println("                INFORMAÇÕES EDUCACIONAIS        ");
            System.out.println("====================================================");
            System.out.println("Histórico do Ensino Médio:    " + historicoEM);
            System.out.println("Reservista:                   " + reservista);
            System.out.println("Comprovante de Residência:    " + comp_resid);
            System.out.println("Colégio Antigo:               " + colegio_antig);
            System.out.println("EJA:                          " + EJA);
            System.out.println("Ensino Técnico:               " + ens_Tec);

            System.out.println("\n====================================================");
            System.out.println("                  ENDEREÇO DO ALUNO             ");
            System.out.println("====================================================");
            System.out.println("Rua:               " + rua);
            System.out.println("Bairro:            " + bairro);
            System.out.println("Número:            " + num);
            System.out.println("Complemento:       " + complemento);
            System.out.println("CEP:               " + CEP);
            System.out.println("Cidade:            " + Cidade);
            System.out.println("Estado:            " + estado);

            bancoDeDados.fecharConexao();

            System.out.println("===================================================");

        } else {
            System.out.println("Não foi encontrado histórico com este ID.");
        }
    }

    /**
     * Consulta parcelas relacionadas ao aluno.
     *
     * @param base ResultSet contendo os resultados da consulta.
     * @throws SQLException
     * @throws ParseException
     */
    void ConsultaParcelas(ResultSet base) throws SQLException, ParseException {
        /**
         * Método que consulta e exibe informações sobre as parcelas associadas a um aluno.
         *
         * @param base ResultSet contendo os resultados da consulta.
         * @throws SQLException em caso de erro na consulta SQL.
         * @throws ParseException em caso de erro na conversão de data.
         */
        System.out.println(
                "================================================== Parcelas ==================================================");

        System.out.println(
                "+--------+-------------+-----------+--------------+---------------------+------------------------+-------+");
        System.out.printf("| %-6s | %-11s | %-9s | %-12s | %-19s | %-20s | %-5s |%n",
                "ID", "Ano/Mês", "Status", "Valor", "Data Emissão", "Data Vencimento", "Doc ID");
        System.out.println(
                "+--------+-------------+-----------+--------------+---------------------+------------------------+-------+");

        if (base.next()) {
            do {
                int id = base.getInt(1);
                String anomes = base.getString(2);
                String status = base.getString(3);
                float valor = base.getFloat(4);
                Date dataemi = base.getDate(5);
                Date datavenc = base.getDate(6);
                int docid = base.getInt(7);

                String dataemiFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataemi);
                String datavencFormatada = new SimpleDateFormat("dd/MM/yyyy").format(datavenc);

                System.out.printf("| %-6d | %-11s | %-9s | %-12.2f | %-19s | %-20s | %-5d |%n",
                        id, anomes, status, valor, dataemiFormatada, datavencFormatada, docid);
                System.out.println(
                        "+--------+-------------+-----------+--------------+---------------------+------------------------+-------+");
            } while (base.next());
        } else {
            System.out.println("Sem parcelas");
        }
    }

    /**
     * Consulta alunos associados a um curso.
     *
     * @param base ResultSet contendo os resultados da consulta.
     * @throws SQLException
     */
    void ConsultaAlunosCurso(ResultSet base) throws SQLException {
        /**
         * Método que consulta e exibe a lista de alunos associados a um curso.
         *
         * @param base ResultSet contendo os resultados da consulta.
         * @throws SQLException em caso de erro na consulta SQL.
         */
        System.out.println("============== Alunos do Curso ==============");

        while (base.next()) {
            int idaluno = base.getInt(1);
            String nome = base.getString(2);

            System.out.println("ID: " + idaluno + " - " + nome);
        }
        System.out.println("=============================================");

        bancoDeDados.fecharConexao();
    }
}
