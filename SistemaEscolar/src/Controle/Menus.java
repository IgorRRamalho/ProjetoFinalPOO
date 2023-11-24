package Controle;
import java.util.Scanner;

public class Menus {
    Scanner leitor = new Scanner(System.in);
    Utilitarios util = new Utilitarios();
    public void menuInical() {
        System.out.print("##--Menu Inicial--##\n\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("| Opção 1 - Gerenciar Alunos    |\n");
        System.out.print("| Opção 2 - Gerenciar Cursos    |\n");
        System.out.print("| Opção 3 - Gerenciar Materias  |\n");
        System.out.print("| Opção 4 - Voltar              |\n");
        System.out.print("| Opção 5 - Sair                |\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = leitor.nextInt();
        util.limparTelaConsole();

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

    public void menuAluno(){
        System.out.print("##--Menu Aluno--##\n\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("| Opção 1 - Adiconar Aluno      |\n");
        System.out.print("| Opção 2 - Remover Aluno       |\n");
        System.out.print("| Opção 3 - Alterar Aluno       |\n");
        System.out.print("| Opção 4 - Sair                |\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = leitor.nextInt();
        util.limparTelaConsole();

        switch (opcao) {
            case 1:
                //adicionaAluno();
                break;
            case 2:
                //removeAluno();
                break;
            case 3:
                //alteraAluno();
                break;
            default:
                break;
        }
    }
    public void menuCurso(){
        System.out.print("##--Menu Curso--##\n\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("| Opção 1 - Adiconar Curso      |\n");
        System.out.print("| Opção 2 - Remover Curso       |\n");
        System.out.print("| Opção 3 - Alterar Curso       |\n");
        System.out.print("| Opção 4 - Voltar              |\n");
        System.out.print("| Opção 5 - Sair                |\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = leitor.nextInt();
        util.limparTelaConsole();

        switch (opcao) {
            case 1:
                //adicionaCurso();
                break;
            case 2:
                //removeCurso();
                break;
            case 3:
                //alteraCurso();
                break;
            case 4: 
                menuInical();
                break;
            default:
                break;
        }
    }
    public void menuMateria(){
        System.out.print("##--Menu Materia--##\n\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("| Opção 1 - Adiconar Materia    |\n");
        System.out.print("| Opção 2 - Remover Materia     |\n");
        System.out.print("| Opção 3 - Alterar Materia     |\n");
        System.out.print("| Opção 4 - Voltar              |\n");
        System.out.print("| Opção 5 - Sair                |\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = leitor.nextInt();
        util.limparTelaConsole();

        switch (opcao) {
            case 1:
                //adicionaMateria();
                break;
            case 2:
                //removeMateria();
                break;
            case 3:
                //alteraMateria();
                break;
            case 4: 
                menuInical();
                break;
            default:
                break;
        }
    }

}