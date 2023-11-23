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
        System.out.print("| Opção 4 - Sair                |\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = leitor.nextInt();
        util.limparTelaConsole();

        switch (opcao) {
            case 1:

                break;
            case 2:
                break;

            case 3:
                break;
            
            
            
            
                default:
                break;
        }

    }

    public void menuAluno(){
          System.out.print("##--Menu Aluno--##\n\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("| Opção 1 - Inserir Aluno       |\n");
        System.out.print("| Opção 2 - Remover Aluno   |\n");
        System.out.print("| Opção 3 - Consulta De Dados  |\n");
        System.out.print("| Opção 4 -  Inserir Dados do Aluno     |\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = leitor.nextInt();
        util.limparTelaConsole();

          switch (opcao) {
            case 1:

                break;
            case 2:
                break;

            case 3:
                break;
            
            
            
            
                default:
                break;
        }



    }


    public void menu



}
