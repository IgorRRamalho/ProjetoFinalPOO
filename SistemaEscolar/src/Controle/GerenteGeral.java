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

    void Atualizar();

    void Consultar() throws SQLException, ParseException;

    Materias MateriasC = new Materias();
    Curso CursoC = new Curso();
    Aluno AlunoC = new Aluno();
    GerenteSQL<CursoM> gerenteCurso = new GerenteSQL.Curso();

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

            // InserirSQL(curso);

            int quant = Input.readInt("Informe a quantidade de matérias existentes no curso:");

            for (int i = 0; i < quant; i++) {
                System.out.println("--------------- Cadastro de Matérias no Curso ---------------");
                int idMateria = Input.readInt("ID Matéria: ");
                if (util.verificaIDMaterias(idMateria) == 0) {
                    System.out.println("MATÉRIA NÃO EXISTE CARAHO");
                    i--;

                } else {

                    GradeCursoM grade = new GradeCursoM(util.getIDcurso(nomeCurso), idMateria);

                    BancoDeDados bancoDeDados = new BancoDeDados();
                    bancoDeDados.abrirConexao();

                    try {
                        String query = "INSERT INTO grade_curso (curso_id, materia_id)"
                                + " VALUES(?, ?);";

                        PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                        preparedStatement.setInt(1, util.getIDcurso(nomeCurso));
                        preparedStatement.setInt(2, grade.getMateriaId());

                        preparedStatement.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        bancoDeDados.fecharConexao();
                    }

                }
            }

        }

        @Override
        public void Remover() {

            int idCurso = Input.readInt("Digite o ID do curso: ");

            // RemoverSQL(idCurso);

        }

        @Override
        public void Atualizar() {
            int idCurso = Input.readInt("ID do curso: ");
            String nomeCurso = Input.readString("Novo nome do curso: ");
            String turno = Input.readString("Novo turno: ");
            String dataCriacao = Input.readString("Nova data de criação: ");
            int notaMec = Input.readInt("Nova Nota MEC: ");
            int quantSemestres = Input.readInt("Nova quantidade de Semestres: ");
            int minEducacaoId = Input.readInt("Nova identificação no MEC: ");
            String anoAltGrade = Input.readString("Novo ano de alteração da grade curricular: ");
            int tcc = Input.readInt("Possui TCC (1 para Sim, 0 para Não): ");
            int creditos = Input.readInt("Nova quantidade de créditos: ");
            int horasComplementares = Input.readInt("Nova quantidade de horas complementares exigidas: ");

            // Agora, você precisa implementar o código para realizar a atualização no banco
            // de dados.
            // Utilize uma instrução UPDATE no SQL para alterar os dados do curso com base
            // no ID do curso.
            // Exemplo:
            // UPDATE curso SET nome_curso=?, turno=?, data_criacao=?, nota_mec=?,
            // quant_semestres=?, ...
        }

        @Override
        public void Consultar() throws SQLException, ParseException {
            int idcurso = Input.readInt("DIGITE O ID DO CURSO:");
            ConsultasC menuConsulta = new ConsultasC();
            menuConsulta.ConsultaCursoPorID(gerenteCurso.ConsultarSQL(idcurso));

        }

    }

    public class Materias implements GerenteGeral {
        @Override
        public void Inserir() {
            System.out.println("--------------- Cadastro de Matéria ---------------");
            String nomeMateria = Input.readString("Nome da matéria: ");

            MateriasM materia = new MateriasM(nomeMateria);

            // InserirSQL(materia);

        }

        @Override
        public void Remover() {
            int materiaId = Input.readInt("Digite o ID da matéria: ");

            // RemoverSQL(materiaId);
        }

        @Override
        public void Atualizar() {
            int idMateria = Input.readInt("ID da matéria: ");
            String novoNomeMateria = Input.readString("Novo nome da matéria: ");

            // Agora, você precisa implementar o código para realizar a atualização no banco
            // de dados.
            // Utilize uma instrução UPDATE no SQL para alterar o nome da matéria com base
            // no ID da matéria.
            // Exemplo:
            // UPDATE materias SET nome_materia=? WHERE materia_id=?
        }

        @Override
        public void Consultar() throws SQLException {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "SELECT * FROM historico WHERE aluno_id = ? AND materia_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                // preparedStatement.setInt(1, idAluno);
                // preparedStatement.setInt(2, idMateria);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Recupere os dados do histórico conforme necessário
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

                // InserirSQL(aluno, endereco, id_curso);
            }

        }

        @Override
        public void Remover() {
            int idAluno = Input.readInt("Digite o ID do aluno:");

        }

        @Override
        public void Atualizar() {
            int idAluno = Input.readInt("ID do aluno: ");
            String novoNome = Input.readString("Novo nome do aluno: ");
            String novoNomePai = Input.readString("Novo nome do Pai: ");
            String novoNomeMae = Input.readString("Novo nome da Mãe: ");
            String novoRg = Input.readString("Novo RG: ");
            String novoCpf = Input.readString("Novo CPF: ");
            String novaDataNasc = Input.readString("Nova data de Nascimento: ");
            String novoEmail = Input.readString("Novo E-mail: ");
            char novoSexo = Input.readChar("Novo Sexo: ");
            String novoCelular = Input.readString("Novo Celular: ");

            // Agora, você precisa implementar o código para realizar a atualização no banco
            // de dados.
            // Utilize uma instrução UPDATE no SQL para alterar os dados do aluno com base
            // no ID do aluno.
            // Exemplo:
            // UPDATE aluno SET nome=?, nome_pai=?, nome_mae=?, rg=?, cpf=?, data_nasc=?,
            // ...
        }

        @Override
        public void Consultar() throws SQLException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'Consultar'");
        }

    }

}
