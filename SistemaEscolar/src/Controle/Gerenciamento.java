package Controle;

import java.sql.ResultSet;

import Controle.Gerenciamento.GerenteGeral;
import Modelo.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gerenciamento {

    public interface GerenteGeral {
        void Inserir();

        void Remover();

        void Atualizar();

        public class Curso implements GerenteGeral {
            @Override
            public void Inserir() {
                
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
                CursoM Curso = new CursoM(nomeCurso, turno, dataCriacao, notaMec, quantSemestres, minEducacaoId,
                        anoAltGrade, tcc, creditos, horasComplementares);

            }

            @Override
            public void Remover() {
                int idCurso = Input.readInt("Digite o ID do curso: ");

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
        }

        public class Aluno implements GerenteGeral {
            @Override
            public void Inserir() {

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




                AlunoM Aluno = new AlunoM(nomeMae, nomePai, nomeMae, rg, cpf, dataNasc, email, sexo, celular);

            }

            @Override
            public void Remover() {
                int idAluno = Input.readInt("Digite o ID do aluno:");
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
        }

        public class Materias implements GerenteGeral {
            @Override
            public void Inserir() {
                String nomeMateria = Input.readString("Nome da matéria: ");

            }

            @Override
            public void Remover() {
                int materiaId = Input.readInt("Digite o ID da matéria: ");
            }

            @Override
            public void Atualizar() {
                int materiaId = Input.readInt("Digite o ID da matéria: ");
                System.out.println("Atualizar matéria: ");
            }

        }

         public class Endereco implements GerenteGeral {
            @Override
            public void Inserir(AlunoM aluno) {
                String nomeMateria = Input.readString("Nome da matéria: ");

            }

            @Override
            public void Remover() {
                int materiaId = Input.readInt("Digite o ID da matéria: ");
            }

            @Override
            public void Atualizar() {
                int materiaId = Input.readInt("Digite o ID da matéria: ");
                System.out.println("Atualizar matéria: ");
            }

        }

    }

    
    public interface Inserir {
        void DadosPessoais();
        void Endereco();
        void HistoricoM();
        void OrigemM();
        
    }
    
    
    
    public interface GerenteSQL<Modelo> {
        void Inserir(Modelo modelo);

        void Remover();

        void Atualizar();

        BancoDeDados db = new BancoDeDados();
        String sql = null;
        ResultSet dados = null;

        public class Curso implements GerenteSQL<CursoM> {
            @Override
            public void Inserir(CursoM curso) {

            }

            @Override
            public void Remover() {

            }

            @Override
            public void Atualizar() {

            }
        }

        public class Aluno implements GerenteSQL<AlunoM, EnderecoM> {
            @Override
            public void Inserir(AlunoM aluno, EnderecoM endereco) {

                try {
                    db.abrirConexao();

                    // Insert into aluno table
                    String alunoSql = "INSERT INTO hml.aluno(nome, nome_pai, nome_mae, rg, cpf, data_nasc, email, sexo, celular) "
                            +
                            "VALUES('" + aluno.getNome() + "', '" + aluno.getNomePai() + "', '" + aluno.getNomeMae()
                            + "', " +
                            "'" + aluno.getRg() + "', '" + aluno.getCpf() + "', '" + aluno.getDataNasc() + "', " +
                            "'" + aluno.getEmail() + "', '" + aluno.getSexo() + "', '" + aluno.getCelular() + "')";

                    db.getStatement().execute(alunoSql);

                    // Get the generated ID from the aluno table
                    ResultSet alunoResultSet = db.getStatement().executeQuery("SELECT LAST_INSERT_ID() as alunoId");
                    alunoResultSet.next();
                    int alunoId = alunoResultSet.getInt("alunoId");

                    // Insert into endereco table
                    String enderecoSql = "INSERT INTO hml.endereco(aluno_id, rua, bairro, numero, complemento, cep, cidade, estado) "
                            +
                            "VALUES('" + alunoId + "', '" + endereco.getRua() + "', '" + endereco.getBairro() + "', " +
                            "'" + endereco.getNumero() + "', '" + endereco.getComplemento() + "', '" + endereco.getCep()
                            + "', " +
                            "'" + endereco.getCidade() + "', '" + endereco.getEstado() + "')";

                    db.getStatement().execute(enderecoSql);

                    db.fecharConexao();
                } catch (Exception erro) {
                    erro.printStackTrace();
                }

            }

            @Override
            public void Remover() {

            }

            @Override
            public void Atualizar() {

            }
        }

        public class Materias implements GerenteSQL<MateriasM> {
            @Override
            public void Inserir(MateriasM materia) {

            }

            @Override
            public void Remover() {

            }

            @Override
            public void Atualizar() {

            }

        }

    }
}
