package Controle;

import java.sql.SQLException;
import Modelo.AlunoM;
import Modelo.CursoM;
import Modelo.GradeCursoM;
import Modelo.MateriasM;

/**
 * A interface GerenteGeral define métodos básicos para inserção e remoção de
 * entidades.
 * As classes que implementam esta interface são responsáveis por fornecer
 * implementações específicas para esses métodos.
 */
public interface GerenteGeral {

    /**
     * Método para inserir uma entidade específica.
     */
    void Inserir();

    /**
     * Método para remover uma entidade específica.
     */
    void Remover();


/**
 * A classe Curso implementa a interface GerenteGeral e fornece métodos para
 * inserção e remoção de cursos no sistema.
 * Também realiza o cadastro de matérias vinculadas a um curso.
 */
class Curso implements GerenteGeral {

    // Gerentes de SQL para diferentes entidades relacionadas a cursos
    private final GerenteSQL<CursoM> gerenteCursoSQL = new GerenteSQL.Curso();
    private final GerenteSQL<GradeCursoM> gerenteGradeSQL = new GerenteSQL.GradeCurso();
    private final GerenteSQL<MateriasM> gerenteMateriaSQL = new GerenteSQL.Materias();
    private final ConsultasC gerenteConsultasC = new ConsultasC();
    Utilitarios util = new Utilitarios();

    /**
     * Método para inserir um novo curso no sistema.
     * Solicita informações específicas do curso ao usuário,
     * cria uma instância de CursoM e a insere no banco de dados por meio do
     * gerente de SQL correspondente. Realiza também o cadastro de matérias
     * vinculadas ao curso.
     */
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

        gerenteCursoSQL.InserirSQL(curso);

        String prequery = "SELECT * FROM view_todas_materias;";
        try {
            gerenteConsultasC.ConsultaMateria(gerenteMateriaSQL.ConsultarSQL(0, prequery));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int quant = Input.readInt("Informe a quantidade de matérias existentes no curso:");

        for (int i = 0; i < quant; i++) {
            cadastrarMateriaNoCurso(nomeCurso);
        }

        Utilitarios.limparTelaConsole();
        System.out.println("******** CURSO CRIADO ********");
    }

    /**
     * Método para cadastrar uma matéria em um curso.
     * Solicita o ID da matéria ao usuário, verifica se a matéria existe e, caso
     * positivo,
     * cria uma instância de GradeCursoM e a insere no banco de dados por meio do
     * gerente
     * de SQL correspondente.
     * 
     * @param nomeCurso O nome do curso ao qual a matéria será vinculada.
     */
    private void cadastrarMateriaNoCurso(String nomeCurso) {
        System.out.println("--------------- Cadastro de Matérias no Curso ---------------");
        int idMateria = Input.readInt("ID Matéria: ");
        if (util.verificaIDMaterias(idMateria) == 0) {
            System.out.println("\n******** MATÉRIA NÃO EXISTE ********");
            cadastrarMateriaNoCurso(nomeCurso); // Recursivamente tenta novamente
        } else {
            GradeCursoM grade = new GradeCursoM(util.getIDcurso(nomeCurso), idMateria);
            gerenteGradeSQL.InserirSQL(grade);
            System.out.println("\n******** MATÉRIA VINCULADA ********");
        }
    }

    /**
     * Método para remover um curso existente no sistema.
     * Solicita ao usuário o ID do curso a ser removido e o remove do banco de dados
     * por meio do gerente de SQL correspondente.
     */
    @Override
    public void Remover() {
        int idCurso = Input.readInt("Digite o ID do curso: ");
        gerenteCursoSQL.RemoverSQL(idCurso);
        Utilitarios.limparTelaConsole();
        System.out.println("********* CURSO REMOVIDO *********\n");
    }
}

/**
 * A classe Materias implementa a interface GerenteGeral e fornece métodos para
 * inserção e remoção de matérias no sistema.
 */
class Materias implements GerenteGeral {

    // Gerente de SQL para matérias
    private final GerenteSQL<MateriasM> gerenteMateriaSQL = new GerenteSQL.Materias();
    private ConsultasC gerenteConsultasC;

    /**
     * Método para inserir uma nova matéria no sistema.
     * Solicita o nome da matéria ao usuário, cria uma instância de MateriasM
     * e a insere no banco de dados por meio do gerente de SQL correspondente.
     */
    @Override
    public void Inserir() {
        System.out.println("--------------- Cadastro de Matéria ---------------");
        String nomeMateria = Input.readString("Nome da matéria: ");
        MateriasM materia = new MateriasM(nomeMateria);
        gerenteMateriaSQL.InserirSQL(materia);

        Utilitarios.limparTelaConsole();
        System.out.println("********* MATÉRIA CADASTRADA *********\n");
    }

    /**
     * Método para remover uma matéria existente no sistema.
     * Exibe a lista de todas as matérias, solicita ao usuário o ID da matéria a ser
     * removida
     * e a remove do banco de dados por meio do gerente de SQL correspondente.
     */
    @Override
    public void Remover() {
        listarTodasMaterias();
        int materiaId = Input.readInt("Digite o ID da matéria: ");
        gerenteMateriaSQL.RemoverSQL(materiaId);
        Utilitarios.limparTelaConsole();
        System.out.println("********* MATÉRIA REMOVIDA *********\n");
    }

    /**
     * Método para listar todas as matérias disponíveis no sistema.
     */
    private void listarTodasMaterias() {
        String prequery = "SELECT * FROM view_todas_materias;";
        try {
            gerenteConsultasC.ConsultaMateria(gerenteMateriaSQL.ConsultarSQL(0, prequery));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/**
 * A classe Aluno implementa a interface GerenteGeral e fornece métodos para
 * inserção e remoção de alunos no sistema.
 */
class Aluno implements GerenteGeral {

    // Gerente de SQL para alunos
    private final GerenteSQL<AlunoM> gerenteAlunoSQL = new GerenteSQL.Aluno();
    private final Utilitarios util = new Utilitarios();

    /**
     * Método para inserir um novo aluno no sistema.
     * Solicita informações pessoais e de endereço ao usuário, cria uma instância de
     * AlunoM
     * e a insere no banco de dados por meio do gerente de SQL correspondente.
     */
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

        int id_curso = obterIDCursoValido();

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

        gerenteAlunoSQL.InserirSQL(aluno);
        Utilitarios.limparTelaConsole();
        System.out.println("******** ALUNO CRIADO ********");
    }

    /**
     * Método auxiliar para obter um ID de curso válido do usuário.
     * Solicita o ID do curso e verifica se o curso existe no sistema.
     * Se o curso não existir, exibe uma mensagem de erro e solicita novamente.
     * 
     * @return O ID do curso válido.
     */
    private int obterIDCursoValido() {
        boolean testID = true;
        int id_curso = 0;

        while (testID) {
            id_curso = Input.readInt("ID do Curso para Matrícula: ");
            if (!util.verificaIDcurso(id_curso)) {
                Utilitarios.limparTelaConsole();
                System.out.println("******** O CURSO FORNECIDO NÃO EXISTE ********\n");
            } else {
                testID = false;
            }
        }

        return id_curso;
    }

    /**
     * Método para remover um aluno existente no sistema.
     * Solicita ao usuário o ID do aluno a ser removido e o remove do banco de dados
     * por meio do gerente de SQL correspondente.
     */
    @Override
    public void Remover() {
        int idAluno = Input.readInt("Digite o ID do aluno:");
        gerenteAlunoSQL.RemoverSQL(idAluno);
        Utilitarios.limparTelaConsole();
        System.out.println("******** ALUNO REMOVIDO ********");
    }
}
}
