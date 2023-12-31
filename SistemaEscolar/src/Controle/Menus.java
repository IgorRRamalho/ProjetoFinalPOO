package Controle;

import java.sql.SQLException;
import java.text.ParseException;

import Modelo.AlunoM;
import Modelo.CursoM;
import Modelo.GradeCursoM;
import Modelo.MateriasM;

/**
 * A classe Menus contém métodos para exibir e gerenciar menus relacionados a Alunos, Cursos e Matérias.
 * Os métodos incluem operações como inserção, atualização, consulta e remoção de dados.
 * Cada menu oferece opções específicas para interação com o sistema de gerenciamento educacional.
 *
 * @author Giovanna Serejo
 * @author Igor 
 * @author Daniel 
 * @author Yuri 
 * @author Brenno 
 */

public class Menus {

    
    String prequery;

    GerenteSQL<CursoM> gerenteCursoSQL = new GerenteSQL.Curso();
    GerenteSQL<AlunoM> gerenteAlunoSQL = new GerenteSQL.Aluno();
    GerenteSQL<GradeCursoM> gerenteGradeSQL = new GerenteSQL.GradeCurso();
    GerenteSQL<MateriasM> gerenteMateriaSQL = new GerenteSQL.Materias();
    GerenteGeral gerenteCursoGeral = new GerenteGeral.Curso();
    GerenteGeral gerenteAlunoGeral = new GerenteGeral.Aluno();
    GerenteGeral gerenteMateriaGeral = new GerenteGeral.Materias();
    boolean loop = true;

    // Utilitários
    Utilitarios util = new Utilitarios();

    ConsultasC ConsultaControle = new ConsultasC();
    AtualizarC AtualizarControle = new AtualizarC();

    /**
     * Exibe o Menu Inicial do sistema, que oferece opções para acessar menus relacionados a Alunos, Cursos, Materias e Sair.
     * As opções são lidas do usuário e, dependendo da escolha, direciona para o menu correspondente.
     *
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     */
    public void menuInical() throws SQLException, ParseException {
        while (loop) {
            System.out.println("\n\t##--Menu Inicial--##");
            System.out.println("|-------------------------------|");
            System.out.println("| Opção 1 - Alunos              |");
            System.out.println("| Opção 2 - Cursos              |");
            System.out.println("| Opção 3 - Materias            |");
            System.out.println("| Opção 4 - Sair                |");
            System.out.println("|-------------------------------|");
            System.out.print("Digite uma opção: ");

            // Leitura da opção escolhida
            int opcaoC = Input.readInt();

            // Switch para lidar com as opções escolhidas
            switch (opcaoC) {
                case 1:
                    Utilitarios.limparTelaConsole();
                    menuAluno();
                    break;
                case 2:
                    Utilitarios.limparTelaConsole();
                    menuCurso();
                    break;
                case 3:
                    Utilitarios.limparTelaConsole();
                    menuMateria();
                    break;
                case 4:
                    System.out.println("SAINDO ..");
                    loop = false;
                    break;
                default:
                    Utilitarios.limparTelaConsole();
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }
        }

    }

    /**
     * Exibe o Menu de Gerenciamento de Alunos, que inclui opções para inserir novo aluno, gerenciar aluno e voltar ao Menu Inicial.
     * As opções são lidas do usuário e, dependendo da escolha, direciona para as operações correspondentes.
     *
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     * @GiovannaSrj
     */
    public void menuAluno() throws SQLException, ParseException {
        System.out.println("\t##--Menu Aluno--##");

        // Exibição das opções
        System.out.println("|-------------------------------|");
        System.out.println("| Opção 1 - Inserir Novo Aluno  |");
        System.out.println("| Opção 2 - Gerenciar Aluno     |");
        System.out.println("| Opção 3 - Voltar Menu Inicial |");
        System.out.println("|-------------------------------|");
        // Leitura da opção escolhida
        int opcao = Input.readInt("Digite uma opção:");

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                Utilitarios.limparTelaConsole();
                gerenteAlunoGeral.Inserir();
                break;
            case 2:
                int id = Input.readInt("Informe o ID do aluno:");
                if (!util.verificaIDaluno(id)) {
                    Utilitarios.limparTelaConsole();
                    System.out.println("********** ID INVÁLIDO **********");
                } else {
                    Utilitarios.limparTelaConsole();
                    GerenciarAluno(id);
                }
                break;
            case 3:
                Utilitarios.limparTelaConsole();
                menuInical();
                break;
            default:
                Utilitarios.limparTelaConsole();
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    /**
     * Gerencia os dados de um aluno, incluindo dados pessoais, acadêmicos e financeiros.
     * Oferece opções para atualizar diferentes informações associadas ao aluno.
     *
     * @param id ID do aluno a ser gerenciado
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     * @IgorRRamalho
     */
    public void GerenciarAluno(int id) throws SQLException, ParseException {
        boolean loop2 = true;
        int idmat;
        while (loop2) {
            System.out.println("\t##--Menu Gerenciar Aluno--##");
            // Exibição das opções
            System.out.println("|-----------------------------------------|");
            System.out.println("| Opção 1 - Gerenciar Dados Pessoais      |");
            System.out.println("| Opção 2 - Gerenciar Dados Acadêmicos    |");
            System.out.println("| Opção 3 - Gerenciar Dados Financeiros   |");
            System.out.println("| Opção 0 - Voltar Menu Inicial           |");
            System.out.println("|-----------------------------------------|");
            int opcao = Input.readInt("Digite uma opção:");

            // Leitura da opção escolhida

            // Switch para lidar com as opções escolhidas
            switch (opcao) {
                case 1:
                    Utilitarios.limparTelaConsole();
                    GerenciarDPessoais(id);
                    break;
                case 2:
                    Utilitarios.limparTelaConsole();
                    prequery = "SELECT * FROM view_todas_materias;";
                    ConsultaControle.ConsultaMateria(gerenteMateriaSQL.ConsultarSQL(0, prequery));
                    idmat = Input.readInt("Digite o ID da matéria: ");
                    if (util.verificaIDMaterias(idmat) == 0) {
                        System.out.println("********* ID INVÁLIDO *********");
                    } else {
                        Utilitarios.limparTelaConsole();
                        GerenciarDAcademicos(id, idmat);
                    }
                    break;
                case 3:
                    Utilitarios.limparTelaConsole();
                    GerenciarDFinanceiros(id);
                    break;
                case 0:
                    Utilitarios.limparTelaConsole();
                    loop2 = false;
                    break;
                default:
                    Utilitarios.limparTelaConsole();
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }

        }
    }

    /**
     * Gerencia os dados pessoais de um aluno, oferecendo opções para atualizar informações como histórico escolar, reservista, etc.
     *
     * @param id ID do aluno cujos dados pessoais serão gerenciados
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     * @DaniPorto
     */
    public void GerenciarDPessoais(int id) throws SQLException, ParseException {
        System.out.println("  ##--Menu Gerenciar Dados Pessoais--##");
        System.out.println("|----------------------------------------|");
        System.out.println("| Opção 1 - Atualizar Dados de Origem    |");
        System.out.println("| Opção 2 - Consulta Dados Pessoais      |");
        System.out.println("| Opção 0 - Voltar Menu Inicial          |");
        System.out.println("|----------------------------------------|");
        int opcao = Input.readInt("Digite uma opção:");

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                Utilitarios.limparTelaConsole();
                AtualizarOrigem(id);
                break;
            case 2:
                Utilitarios.limparTelaConsole();
                prequery = "SELECT * FROM view_dados_pessoais_aluno WHERE aluno_id = ?;";
                ConsultaControle.ConsultaDPessoais(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            case 0:
                Utilitarios.limparTelaConsole();
                menuInical();
                break;
            default:
                Utilitarios.limparTelaConsole();
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    /**
     * Atualiza informações relacionadas à origem de um aluno, como histórico escolar, reservista, etc.
     *
     * @param id ID do aluno cuja origem será atualizada
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     * @Brenno
     */
    public void AtualizarOrigem(int id) throws SQLException, ParseException {
        System.out.println("\t##--Menu Atualizar Origem--##");
        System.out.println("|----------------------------------------------|");
        System.out.println("| Opção 1 - Atualizar Histórico EM             |");
        System.out.println("| Opção 2 - Atualizar Reservista               |");
        System.out.println("| Opção 3 - Atualizar Comprovante Residencia   |");
        System.out.println("| Opção 4 - Atualizar EJA                      |");
        System.out.println("| Opção 5 - Atualizar Ensino Tecnico           |");
        System.out.println("| Opção 6 - Atualizar Colegio Antigo           |");
        System.out.println("| Opção 0 - Voltar Menu Inicial                |");
        System.out.println("|----------------------------------------------|");
        int opcao = Input.readInt("Digite uma opção:");

        switch (opcao) {
            case 1:
                byte sitHistoricoEm = (byte) Input.readInt("Atualizar para Entregue(1) ou Não entregue(0):");
                AtualizarControle.AtualizarOrigem(id, "historico_em", sitHistoricoEm);
                Utilitarios.limparTelaConsole();
                System.out.println("******* ATUALIZADO COM SUCESSO ******* ");
                break;
            case 2:
                byte sitReservista = (byte) Input.readInt("Atualizar para Entregue(1) ou Não entregue(0):");
                AtualizarControle.AtualizarOrigem(id, "reservista", sitReservista);
                Utilitarios.limparTelaConsole();
                System.out.println("******* ATUALIZADO COM SUCESSO ******* ");
                break;
            case 3:
                byte sitCompResidencia = (byte) Input.readInt("Atualizar para Entregue(1) ou Não entregue(0):");
                AtualizarControle.AtualizarOrigem(id, "comp_residencia", sitCompResidencia);
                Utilitarios.limparTelaConsole();
                System.out.println("******* ATUALIZADO COM SUCESSO ******* ");
                break;
            case 4:
                byte sitEja = (byte) Input.readInt("Atualizar para Entregue(1) ou Não entregue(0):");
                AtualizarControle.AtualizarOrigem(id, "eja", sitEja);
                Utilitarios.limparTelaConsole();
                System.out.println("******* ATUALIZADO COM SUCESSO ******* ");
                break;
            case 5:
                byte sitEnsinoTecnico = (byte) Input.readInt("Atualizar para Entregue(1) ou Não entregue(0):");
                AtualizarControle.AtualizarOrigem(id, "ensino_tecnico", sitEnsinoTecnico);
                Utilitarios.limparTelaConsole();
                System.out.println("******* ATUALIZADO COM SUCESSO ******* ");
                break;

            case 6:
                String novoColegioAntigo = Input.readString("Digite o novo valor para Colegio Antigo:");
                AtualizarControle.AtualizarColegioAntigo(id, novoColegioAntigo);
                Utilitarios.limparTelaConsole();
                System.out.println("******* ATUALIZADO COM SUCESSO ******* ");
                break;
            case 0:
                Utilitarios.limparTelaConsole();
                menuInical();
                break;
            default:
                Utilitarios.limparTelaConsole();
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    /**
     * Gerencia os dados acadêmicos de um aluno, oferecendo opções para atualizar notas e faltas em matérias específicas.
     *
     * @param id ID do aluno cujos dados acadêmicos serão gerenciados
     * @param idmat ID da matéria associada aos dados acadêmicos
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     * @Yuri
     */
    public void GerenciarDAcademicos(int id, int idmat) throws SQLException, ParseException {
        float nota;
        System.out.println("##--Menu Gerenciar Dados Acadêmicos--##");
        System.out.println("|---------------------------------|");
        System.out.println("| Opção 1 - Atualizar Nota P1     |");
        System.out.println("| Opção 2 - Atualizar Nota P2     |");
        System.out.println("| Opção 3 - Atualizar Faltas      |");
        System.out.println("| Opção 4 - Consultar Notas       |");
        System.out.println("| Opção 0 - Voltar Menu Inicial   |");
        System.out.println("|---------------------------------|");
        int opcao = Input.readInt("Digite uma opção:");

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                nota = Input.readInt("Digite a nota para P1: ");
                AtualizarControle.AtualizarNotaProva1(id, idmat, nota);
                break;
            case 2:
                nota = Input.readInt("Digite a nota para P2: ");
                AtualizarControle.AtualizarNotaProva2(id, idmat, nota);
                break;
            case 3:
                int faltas = Input.readInt("Digite a quantidade de faltas: ");
                AtualizarControle.AtualizarNumeroFaltas(id, idmat, faltas);
                Utilitarios.limparTelaConsole();
                System.out.println("****** FALTAS ATUALIZADAS ******");
                break;
            case 4:
                Utilitarios.limparTelaConsole();
                prequery = "SELECT * FROM view_historico WHERE aluno_id = '" + id + "' and materia_id = '" + idmat
                        + "';";
                ConsultaControle.ConsultaHistorico(gerenteMateriaSQL.ConsultarSQL(id, prequery));
                break;
            default:
                Utilitarios.limparTelaConsole();
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    /**
     * Gerencia os dados financeiros de um aluno, oferecendo opções para atualizar pagamentos de parcelas e consultar parcelas.
     *
     * @param id ID do aluno cujos dados financeiros serão gerenciados
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     * @Yuri
     */
    public void GerenciarDFinanceiros(int id) throws SQLException, ParseException {
        System.out.println("  ##--Menu Gerenciar Dados Financeiros--##");

        // Exibição das opções
        System.out.println("|-----------------------------------------|");
        System.out.println("| Opção 1 - Atualizar Pagamento Parcela   |");
        System.out.println("| Opção 2 - Consultar Parcelas            |");
        System.out.println("| Opção 0 - Voltar Menu Inicial           |");
        System.out.println("|-----------------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                String mesano = Input.readString("Digite o Ano/Mes da parcela(YYYYMM): ");
                byte sit = (byte) Input.readInt("Atualizar para pago(1) ou não pago(0): ");
                AtualizarControle.AtualizarSitPag(mesano, id, sit);
                System.out.println("********* PAGAMENTO ATUALIZADO *********");
                break;
            case 2:
                Utilitarios.limparTelaConsole();
                prequery = "SELECT * FROM view_parcelas WHERE aluno_id= ?;";
                ConsultaControle.ConsultaParcelas(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            case 0:
                Utilitarios.limparTelaConsole();
                menuInical();
                break;
            default:
                Utilitarios.limparTelaConsole();
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    /**
     * Exibe o Menu de Cursos, que inclui opções para inserir novo curso, gerenciar curso e voltar ao Menu Inicial.
     * As opções são lidas do usuário e, dependendo da escolha, direciona para as operações correspondentes.
     *
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     */
    public void menuCurso() throws SQLException, ParseException {
        System.out.println("\t##--Menu Curso--##");
        System.out.println("|--------------------------------|");
        System.out.println("| Opção 1 - Inserir Curso        |");
        System.out.println("| Opção 2 - Gerenciar Curso      |");
        System.out.println("| Opção 0 - Voltar Menu Inicial  |");
        System.out.println("|--------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                Utilitarios.limparTelaConsole();

                gerenteCursoGeral.Inserir();
                break;
            case 2:
                int id = Input.readInt("Informe o ID do Curso:");
                if (!util.verificaIDcurso(id)) {
                    Utilitarios.limparTelaConsole();
                    System.out.println("******** ID INVÁLIDO ********");
                } else {
                    Utilitarios.limparTelaConsole();
                    GerenciarCurso(id);

                }
                break;
            case 0:
                Utilitarios.limparTelaConsole();
                menuInical();
                break;
            default:
                Utilitarios.limparTelaConsole();
                System.out.println("OPÇÃO INVÁLIDA");
                break;
        }
    }

    /**
     * Gerencia os dados de um curso, oferecendo opções para remover o curso, consultar informações e listar alunos associados.
     *
     * @param id ID do curso a ser gerenciado
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     */
    public void GerenciarCurso(int id) throws SQLException, ParseException {
        System.out.println("\t##--Menu Gerenciar Curso--##");
        System.out.println("|--------------------------------------|");
        System.out.println("| Opção 1 - Remover Curso              |");
        System.out.println("| Opção 2 - Consultar Informações      |");
        System.out.println("| Opção 3 - Consultar Alunos           |");
        System.out.println("| Opção 0 - Voltar Menu Inicial        |");
        System.out.println("|--------------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                Utilitarios.limparTelaConsole();
                gerenteCursoSQL.RemoverSQL(id);
                break;
            case 2:
                Utilitarios.limparTelaConsole();
                prequery = "SELECT * FROM view_todos_cursos_com_materias WHERE curso_id= ?;";
                ConsultaControle.ConsultaCursoPorID(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            case 3:
                Utilitarios.limparTelaConsole();
                prequery = "SELECT * FROM view_dados_academicos where curso_id = ?;";
                ConsultaControle.ConsultaAlunosCurso(gerenteCursoSQL.ConsultarSQL(id, prequery));
                break;
            case 0:
                Utilitarios.limparTelaConsole();
                menuInical();
                break;
            default:
                break;
        }
    }

    /**
     * Exibe o Menu de Matérias, que inclui opções para inserir nova matéria, remover matéria, consultar todas as matérias e voltar ao Menu Inicial.
     * As opções são lidas do usuário e, dependendo da escolha, direciona para as operações correspondentes.
     *
     * @throws SQLException em caso de erro na execução de consultas SQL
     * @throws ParseException se houver um erro durante a análise de entrada
     */
    public void menuMateria() throws SQLException, ParseException {
        System.out.println("\t  ##--Menu Materia--##");
        System.out.println("|--------------------------------------|");
        System.out.println("| Opção 1 - Inserir Materia            |");
        System.out.println("| Opção 2 - Remover Materia            |");
        System.out.println("| Opção 3 - Consultar Todas Materias   |");
        System.out.println("| Opção 0 - Voltar Menu Inicial        |");
        System.out.println("|--------------------------------------|");
        System.out.print("Digite uma opção: ");

        // Leitura da opção escolhida
        int opcao = Input.readInt();

        // Switch para lidar com as opções escolhidas
        switch (opcao) {
            case 1:
                Utilitarios.limparTelaConsole();
                gerenteMateriaGeral.Inserir();
                break;
            case 2:
                Utilitarios.limparTelaConsole();
                gerenteMateriaGeral.Remover();
                break;
            case 3:
                Utilitarios.limparTelaConsole();
                prequery = "SELECT * FROM view_todas_materias;";
                ConsultaControle.ConsultaMateria(gerenteMateriaSQL.ConsultarSQL(0, prequery));
                break;
            case 0:
                Utilitarios.limparTelaConsole();
                menuInical();
                break;

            default:
                Utilitarios.limparTelaConsole();
                System.out.println("OPÇÃO INVÁLIDA\n");
                break;
        }
    }

}
