package Controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Controle.Gerenciamento.GerenteGeral;
import Controle.Gerenciamento.GerenteGeral.*;
import Controle.Gerenciamento.GerenteSQL.*;

import Modelo.*;

public class Gerenciamento {

    Materias MateriasC = new Materias();
    Curso CursoC = new Curso();
    Aluno AlunoC = new Aluno();

    Utilitarios util = new Utilitarios();

    public interface GerenteGeral {
        void Inserir();

        void Remover();

        void Atualizar();

        void Consultar(int idAluno, int idMateria);

    }

    public interface GerenteSQL<Modelo> extends GerenteGeral {
        void InserirSQL(AlunoM aluno, EnderecoM endereco, int idaluno);

        void RemoverSQL(int aluno);

        void AtualizarSQL(Modelo objeto, int IDaluno);

    }

    public class Curso implements GerenteGeral{
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

            InserirSQL(curso);

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
      
        public void InserirSQL(CursoM curso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO hml.curso (nome_curso, turno, data_criacao, nota_mec, quant_semestres, min_educacao_id, ano_alt_grade, tcc, creditos, horas_complementares)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, curso.getNomeCurso());
                preparedStatement.setString(2, curso.getTurno());

                // Convert the date to the 'YYYY-MM-DD' format
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(curso.getDataCriacao());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                preparedStatement.setDate(3, sqlDate);
                preparedStatement.setInt(4, curso.getNotaMec());
                preparedStatement.setInt(5, curso.getQuantSemestres());
                preparedStatement.setInt(6, curso.getMinEducacaoId());
                preparedStatement.setString(7, curso.getAnoAltGrade());
                preparedStatement.setInt(8, curso.getTcc());
                preparedStatement.setInt(9, curso.getCreditos());
                preparedStatement.setInt(10, curso.getHorasComplementares());

                preparedStatement.executeUpdate();
                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();

            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
            }
        }

        @Override
        public void Remover() {

            int idCurso = Input.readInt("Digite o ID do curso: ");

            RemoverSQL(idCurso);

        }

        public void RemoverSQL(int idCurso) {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "DELETE FROM curso WHERE curso_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idCurso);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void Atualizar() {
            String IDcurso = Input.readString("ID do curso: ");
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

        }

        @Override
        public void Consultar(int idAluno, int idMateria) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'Consultar'");
        }

    }

    public class Materias implements GerenteGeral {
        @Override
        public void Inserir() {
            System.out.println("--------------- Cadastro de Matéria ---------------");
            String nomeMateria = Input.readString("Nome da matéria: ");

            MateriasM materia = new MateriasM(nomeMateria);

            InserirSQL(materia);

        }

        public void InserirSQL(MateriasM materia) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO hml.materias (nome_materia) "
                        + "VALUES(?);";

                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, materia.getNomeMateria());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
            }
        }

        @Override
        public void Remover() {
            int materiaId = Input.readInt("Digite o ID da matéria: ");

            RemoverSQL(materiaId);
        }


        public void RemoverSQL(int materiaId) {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "DELETE FROM curso WHERE materia_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, materiaId);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void Atualizar() {
            int materiaId = Input.readInt("Digite o ID da matéria: ");
            System.out.println("Atualizar matéria: ");
        }

        @Override
        public void Consultar(int idAluno, int idMateria) {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "SELECT * FROM historico WHERE aluno_id = ? AND materia_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idAluno);
                preparedStatement.setInt(2, idMateria);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Recupere os dados do histórico conforme necessário
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

                AlunoM aluno = new AlunoM(nome, nomePai, nomeMae, rg, cpf, dataNasc, email, sexo, celular);
                EnderecoM endereco = new EnderecoM(rua, bairro, numero, complemento, cep, cidade, estado);

                InserirSQL(aluno, endereco, id_curso);
            }

        }

        public void InserirSQL(AlunoM aluno, EnderecoM endereco, int id_curso) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            bancoDeDados.abrirConexao();

            try {
                String query = "INSERT INTO aluno(nome, nome_pai, nome_mae, rg, cpf, data_nasc, email, sexo, celular)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, aluno.getNome());
                preparedStatement.setString(2, aluno.getNomePai());
                preparedStatement.setString(3, aluno.getNomeMae());
                preparedStatement.setString(4, aluno.getRg());
                preparedStatement.setString(5, aluno.getCpf());

                // Convert the date to the 'YYYY-MM-DD' format
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(aluno.getDataNasc());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                preparedStatement.setDate(6, sqlDate);
                preparedStatement.setString(7, aluno.getEmail());
                preparedStatement.setString(8, String.valueOf(aluno.getSexo()));
                preparedStatement.setString(9, aluno.getCelular());

                preparedStatement.executeUpdate();
                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();

                query = "INSERT INTO endereco (aluno_id, rua, bairro, numero, complemento, cep, cidade, estado) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = bancoDeDados.getConnection().prepareStatement(query);

                preparedStatement.setInt(1, util.getIDaluno(aluno.getCpf()));
                preparedStatement.setString(2, endereco.getRua());
                preparedStatement.setString(3, endereco.getBairro());
                preparedStatement.setInt(4, endereco.getNumero());
                preparedStatement.setString(5, endereco.getComplemento());
                preparedStatement.setString(6, endereco.getCep());
                preparedStatement.setString(7, endereco.getCidade());
                preparedStatement.setString(8, endereco.getEstado());

                preparedStatement.executeUpdate();

                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();

                query = "INSERT INTO dados_academicos(aluno_id, curso_id)"
                        + "VALUES(?, ?);";
                preparedStatement = bancoDeDados.getConnection().prepareStatement(query);

                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, id_curso);
                preparedStatement.executeUpdate();

                bancoDeDados.fecharConexao();
                bancoDeDados.abrirConexao();
                query = "CALL inserir_historico(?);";

                preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, util.getIDaluno(aluno.getCpf()));
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            } finally {
                bancoDeDados.fecharConexao();
                util.limparTelaConsole();
            }
        }

        @Override
        public void Remover() {
            int idAluno = Input.readInt("Digite o ID do aluno:");

        }

        public void RemoverSQL(int idaluno) {
            BancoDeDados bancoDeDados = new BancoDeDados();
            try {
                String query = "UPDATE aluno SET sit_aluno=b'0' WHERE aluno_id=?;";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, idaluno);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void Atualizar() {
            String IDaluno = Input.readString("ID do aluno: ");
            int nome = Input.readInt("Nome do aluno: ");
            String nomePai = Input.readString("Nome do Pai: ");
            String nomeMae = Input.readString("Nome da Mãe: ");
            String rg = Input.readString("RG: ");
            String cpf = Input.readString("CPF: ");
            String dataNasc = Input.readString("Data de Nascimento: ");
            String email = Input.readString("E-mail: ");
            char sexo = Input.readChar("Sexo: ");
            String celular = Input.readString("Celular: ");

            String rua = Input.readString("Rua: ");
            String bairro = Input.readString("Bairro: ");
            int numero = Input.readInt("Número: ");
            String complemento = Input.readString("Complemento: ");
            String cep = Input.readString("CEP: ");
            String cidade = Input.readString("Cidade: ");
            String estado = Input.readString("Estado: ");

        }

        public void AtualizarSQL(AlunoM aluno, int IDaluno) {
            BancoDeDados bancoDeDados = new BancoDeDados();

            try {
                String query = "UPDATE aluno SET nome = ?, nome_pai = ?, nome_mae = ?, rg = ?, cpf = ?, " +
                        "data_nasc = ?, email = ?, sexo = ?, celular = ? WHERE aluno_id = ?";
                PreparedStatement preparedStatement = bancoDeDados.getConnection().prepareStatement(query);
                preparedStatement.setString(1, aluno.getNome());
                preparedStatement.setString(2, aluno.getNomePai());
                preparedStatement.setString(3, aluno.getNomeMae());
                preparedStatement.setString(4, aluno.getRg());
                preparedStatement.setString(5, aluno.getCpf());
                preparedStatement.setString(6, aluno.getDataNasc());
                preparedStatement.setString(7, aluno.getEmail());
                preparedStatement.setString(8, String.valueOf(aluno.getSexo()));
                preparedStatement.setString(9, aluno.getCelular());
                preparedStatement.setInt(10, IDaluno);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void Consultar(int idAluno, int idMateria) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'Consultar'");
        }
    }
}
