package Controle;

import java.sql.SQLException;
import java.text.ParseException;

import Modelo.AlunoM;
import Modelo.CursoM;
import Modelo.GradeCursoM;
import Modelo.MateriasM;

public class Menus {

    String prequery;

    // GerenteGeral para cursos
    GerenteGeral gerenteCurso = new GerenteGeral.Curso();

    GerenteSQL<CursoM> gerenteCursoSQL = new GerenteSQL.Curso();
    GerenteSQL<AlunoM> gerenteAlunoSQL = new GerenteSQL.Aluno();
    GerenteSQL<GradeCursoM> gerenteGradeSQL = new GerenteSQL.GradeCurso();
    GerenteSQL<MateriasM> gerenteMateriaSQL = new GerenteSQL.Materias();

    // Utilitários
    Utilitarios util = new Utilitarios();

    ConsultasC ConsultaControle = new ConsultasC();

    // Menu inicial
    public void menuInical() throws SQLException, ParseException {
        System.out.println("##--Menu Inicial--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Alunos              |");
        System.out.println("| Opção 2 - Cursos              |");
        System.out.println("| Opção 3 - Materias            |");
        System.out.println("| Opção 4 - Sair                |");
        System.out.println("|-------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                menuAluno();
                break;
            case 2:
                menuCurso();
                break;
            case 3:
                menuMateria();
                break;
            case 4:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de alunos
    public void menuAluno() throws SQLException, ParseException {
        System.out.println("##--Menu Aluno--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Inserir Novo Aluno  |");
        System.out.println("| Opção 2 - Gerenciar Aluno     |");
        System.out.println("| Opção 3 - Voltar Menu Inicial |");
        System.out.println("|-------------------------------|");

        // Leitura da opção escolhida
        int opcao = Input.readInt();
        util.limparTelaConsole();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                GerenteGeral.AlunoC.Inserir();
                break;
            case 2:
                System.out.println("Informe o ID do aluno:");
                int id = Input.readInt();
                GerenciarAluno(id);
                break;
            case 3:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados de alunos
    public void GerenciarAluno(int id) throws SQLException, ParseException {
        System.out.println("##--Menu Gerenciar Aluno--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Gerenciar Dados Pessoais      |");
        System.out.println("| Opção 2 - Gerenciar Dados Acadêmicos    |");
        System.out.println("| Opção 3 - Gerenciar Dados Financeiros   |");
        System.out.println("| Opção 4 - Voltar Menu Inicial          |");
        System.out.println("|-------------------------------|");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                GerenciarDPessoais(id);
                break;
            case 2:
                GerenciarDAcademicos(id);
                break;
            case 3:
                GerenciarDFinanceiros(id);
                break;
            case 4:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados pessoais de alunos
    public void GerenciarDPessoais(int id) throws SQLException, ParseException {
        System.out.println("##--Menu Gerenciar Dados Pessoais--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Atualizar Dados de Origem     |");
        System.out.println("| Opção 2 - Atualizar Endereço            |");
        System.out.println("| Opção 3 - Consulta Dados Pessoas            |");
        System.out.println("| Opção 3 - Voltar Menu Inicial           |");
        System.out.println("|-------------------------------|");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                // Aluno.AtualizarOrigem();
                break;
            case 2:
                // Aluno.AtualizarEndereço;
                break;
            case 3:
                prequery = "SELECT * FROM view_dados_pessoais_aluno WHERE aluno_id = ?;";
                ConsultaControle.ConsultaDPessoais(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados acadêmicos de alunos
    public void GerenciarDAcademicos(int id) throws SQLException, ParseException {
        System.out.println("##--Menu Gerenciar Dados Acadêmicos--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Atualizar Nota P1     |");
        System.out.println("| Opção 2 - Atualizar Nota P2     |");
        System.out.println("| Opção 3 - Atualizar Faltas      |");
        System.out.println("| Opção 4 - Voltar Menu Inicial   |");
        System.out.println("|-------------------------------|");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                // GerenteGeral.AlunoC.AtualizarP1();
                break;
            case 2:
                // GerenteGeral.AlunoC.AtualizarP2();
                break;
            case 3:
                // GerenteGeral.AlunoC.AtualizarFaltas();
                break;
            case 4:
                prequery = "SELECT * FROM view_historico WHERE aluno_id = ?;";
                ConsultaControle.ConsultaHistorico(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados financeiros de alunos
    public void GerenciarDFinanceiros(int id) throws SQLException, ParseException {
        System.out.println("##--Menu Gerenciar Dados Financeiros--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Atualizar Pagamento Parcela      |");
        System.out.println("| Opção 2 - Consultar Parcelas por Semestre/Mês |");
        System.out.println("| Opção 5 - Voltar Menu Inicial                |");
        System.out.println("|-------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                // AtualizarParcela();
                break;
            case 2:
                // ConsultarParcelas();
                break;
            case 3:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de cursos
    public void menuCurso() throws SQLException, ParseException {
        System.out.println("##--Menu Curso--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Inserir Curso        |");
        System.out.println("| Opção 2 - Gerenciar Curso      |");
        System.out.println("| Opção 3 - Voltar Menu Inicial |");
        System.out.println("|-------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                GerenteGeral.CursoC.Inserir();
                break;
            case 2:
                System.out.println("Informe o ID do Curso:");
                int id = Input.readInt();
                GerenciarCurso(id);
                break;
            case 3:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de cursos
    public void GerenciarCurso(int id) throws SQLException, ParseException {
        System.out.println("##--Menu Gerenciar Curso--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Remover Curso        |");
        System.out.println("| Opção 2 - Consultar Cursos por ID        |");
        System.out.println("| Opção 3 - Consultar Alunos do Curso      |");
        System.out.println("| Opção 4 - Voltar Menu Inicial            |");
        System.out.println("|-------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                gerenteCursoSQL.RemoverSQL(id);
                break;
            case 2:
                prequery = "SELECT * FROM view_todos_cursos_com_materias WHERE curso_id= ?;";
                ConsultaControle.ConsultaCursoPorID(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            case 3:
                prequery = "SELECT * FROM view_dados_academicos where curso_id = ?;";
                ConsultaControle.ConsultaCursoPorID(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            case 4:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de matérias
    public void menuMateria() throws SQLException, ParseException {
        System.out.println("##--Menu Materia--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Inserir Materia      |");
        System.out.println("| Opção 2 - Remover Materia      |");
        System.out.println("| Opção 3 - Consultar Todas Materias    |");
        System.out.println("| Opção 4 - Voltar Menu Inicial  |");
        System.out.println("|-------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                GerenteGeral.MateriasC.Inserir();
                break;
            case 2:
                GerenteGeral.MateriasC.Remover();
                break;
            case 3:
                prequery = "SELECT * FROM view_todas_materias;";
                ConsultaControle.ConsultaMateria(gerenteMateriaSQL.ConsultarSQL(0, prequery));
                break;
            case 4:
                menuInical();
                break;

            default:
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }
}
