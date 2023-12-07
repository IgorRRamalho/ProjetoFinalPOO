package Controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Modelo.*;

public interface GerenteGeral {

    void Inserir();

    void Remover();

    void Consultar(String prequery) throws SQLException, ParseException;

    Materias MateriasC = new Materias();
    Curso CursoC = new Curso();
    Aluno AlunoC = new Aluno();
    GerenteSQL<CursoM> gerenteCursoSQL = new GerenteSQL.Curso();
    GerenteSQL<AlunoM> gerenteAlunoSQL = new GerenteSQL.Aluno();
    GerenteSQL<GradeCursoM> gerenteGradeSQL = new GerenteSQL.GradeCurso();
    GerenteSQL<MateriasM> gerenteMateriaSQL = new GerenteSQL.Materias();

    public Utilitarios util = new Utilitarios();

    public class Curso implements GerenteGeral {
        @Override
        public void Inserir() {

            System.out.println("--------------- Cadastro de Curso ---------------");
            String nomeCurso = Input.readString("Nome do curso: ");
            String turno = Input.readString("Turno: ");
            String dataCriacao = Input.readString("Data de criação: ");
            int notaMec = Input.readInt("Nota MEC: ");
            int quantSemestres = Input.readInt("Quantidade de Semestres: ");
            int minEducacaoId = Input.readInt("Identificação no MEC: ");
            String anoAltGrade = Input.readString("Ano de alteração da grade curricular: ");
            int tcc = Input.readInt("Possui TCC: ");
            int creditos = Input.readInt("Quantidade de créditos: ");
            int horasComplementares = Input.readInt("Quantidade de horas complementares exigidas: ");

            CursoM curso = new CursoM(nomeCurso, turno, dataCriacao, notaMec, quantSemestres, minEducacaoId,
                    anoAltGrade, tcc, creditos, horasComplementares);

            gerenteCursoSQL.InserirSQL(curso, 0);

            int quant = Input.readInt("Informe a quantidade de matérias existentes no curso:");

            for (int i = 0; i < quant; i++) {
                System.out.println("--------------- Cadastro de Matérias no Curso ---------------");
                int idMateria = Input.readInt("ID Matéria: ");
                if (util.verificaIDMaterias(idMateria) == 0) {
                    System.out.println("MATÉRIA NÃO EXISTE CARAHO");
                    i--;

                } else {
                    GradeCursoM grade = new GradeCursoM(util.getIDcurso(nomeCurso), idMateria);
                    gerenteGradeSQL.InserirSQL(grade, 0);

                }
            }

        }

        @Override
        public void Remover() {

            int idCurso = Input.readInt("Digite o ID do curso: ");
            gerenteCursoSQL.RemoverSQL(idCurso);
        }

        @Override
        public void Consultar(String prequery) throws SQLException, ParseException {

            int idcurso = Input.readInt("DIGITE O ID DO CURSO:");

            ConsultasC menuConsulta = new ConsultasC();
            menuConsulta.ConsultaCursoPorID(gerenteCursoSQL.ConsultarSQL(idcurso, prequery));

        }

    }

    public class Materias implements GerenteGeral {
        @Override
        public void Inserir() {
            System.out.println("--------------- Cadastro de Matéria ---------------");
            String nomeMateria = Input.readString("Nome da matéria: ");
            MateriasM materia = new MateriasM(nomeMateria);

        }

        @Override
        public void Remover() {
            int materiaId = Input.readInt("Digite o ID da matéria: ");
            gerenteMateriaSQL.RemoverSQL(materiaId);
        }

        @Override
        public void Consultar(String a) throws SQLException {

        }
    }

    public class Aluno implements GerenteGeral {

        @Override
        public void Inserir() {

            System.out.print("##----------- Dados Pessoais -----------##\n");

            String nome = Input.readString("Nome do aluno: ");
            String nomePai = Input.readString("Nome do Pai: ");
            String nomeMae = Input.readString("Nome da Mãe: ");
            String rg = Input.readString("RG: ");
            String cpf = Input.readString("CPF: ");
            String dataNasc = Input.readString("Data de Nascimento: ");
            String email = Input.readString("E-mail: ");
            char sexo = Input.readChar("Sexo: ");
            String celular = Input.readString("Celular: ");
            int id_curso = Input.readInt("ID do Curso para Matrícula: ");
            if (util.verificaIDcurso(id_curso) == 0) {
                System.out.println("NÃO EXISTE");
            } else {

                util.limparTelaConsole();

                System.out.print("##----------- Endereço -----------##\n");

                String rua = Input.readString("Rua: ");
                String bairro = Input.readString("Bairro: ");
                int numero = Input.readInt("Número: ");
                String complemento = Input.readString("Complemento: ");
                String cep = Input.readString("CEP: ");
                String cidade = Input.readString("Cidade: ");
                String estado = Input.readString("Estado: ");

                AlunoM aluno = new AlunoM(rua, bairro, numero, complemento, cep, cidade, estado, nome, nomePai, nomeMae,
                        rg, cpf, dataNasc, email, sexo, celular, id_curso);

                gerenteAlunoSQL.InserirSQL(aluno, id_curso);

            }

        }

        @Override
        public void Remover() {
            int idAluno = Input.readInt("Digite o ID do aluno:");
            gerenteAlunoSQL.RemoverSQL(idAluno);

        }

        @Override
        public void Consultar(String prequery) throws SQLException, ParseException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'Consultar'");
        }

    }

}
