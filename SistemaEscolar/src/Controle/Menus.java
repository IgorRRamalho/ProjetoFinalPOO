package Controle;

public class Menus {

    // GerenteGeral para cursos
    GerenteGeral gerenteCurso = new GerenteGeral.Curso();

    // Utilitários
    Utilitarios util = new Utilitarios();

    // Menu inicial
    public void menuInical() {
        System.out.println("##--Menu Inicial--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Gerenciar Alunos    |");
        System.out.println("| Opção 2 - Gerenciar Cursos    |");
        System.out.println("| Opção 3 - Gerenciar Materias  |");
        System.out.println("| Opção 4 - Voltar              |");
        System.out.println("| Opção 5 - Sair                |");
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
    public void menuAluno() {
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
                GerenciarAluno();
                break;
            case 3:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados de alunos
    public void GerenciarAluno() {
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
                GerenciarDPessoais();
                break;
            case 2:
                GerenciarDAcademicos();
                break;
            case 3:
                GerenciarDFinanceiros();
                break;
            case 4:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados pessoais de alunos
    public void GerenciarDPessoais() {
        System.out.println("##--Menu Gerenciar Dados Pessoais--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Atualizar Dados de Origem     |");
        System.out.println("| Opção 2 - Atualizar Endereço            |");
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
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados acadêmicos de alunos
    public void GerenciarDAcademicos() {
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
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de dados financeiros de alunos
    public void GerenciarDFinanceiros() {
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
    public void menuCurso() {
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
                GerenciarCurso();
                break;
            case 3:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de gerenciamento de cursos
    public void GerenciarCurso() {
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
                GerenteGeral.CursoC.Remover();
                break;
            case 2:
                // ConsultarPorID();
                break;
            case 3:
                // ConsultarPorAluno();
                break;
            case 4:
                menuInical();
                break;
            default:
                break;
        }
    }

    // Menu de matérias
    public void menuMateria() {
        System.out.println("##--Menu Materia--##\n");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Inserir Materia      |");
        System.out.println("| Opção 2 - Remover Materia      |");
        System.out.println("| Opção 3 - Consultar Materia    |");
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
                // GerenteGeral.MateriasC.Consultar();
                break;
            case 4:
                menuInical();
                break;
            default:
                break;
        }
    }
}
