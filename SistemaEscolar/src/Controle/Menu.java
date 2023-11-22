package Controle;

import java.util.Scanner;

public class Menu {
    Scanner leitor = new Scanner(System.in);
    Utilitarios util = new Utilitarios();

    void menu(){
        System.out.print("##--Menu Inicial--##\n\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("| Opção 1 - Gerenciar Cursos    |\n");
        System.out.print("| Opção 2 - Gerenciar Materias  |\n");
        System.out.print("| Opção 3 - Gerenciar Alunos    |\n");
        System.out.print("| Opção 4 - Sair                |\n");
        System.out.print("|-------------------------------|\n");
        System.out.print("Digite uma opção: ");

        int opcao = leitor.nextInt();

        util.limparTelaConsole();



    }

    
}
