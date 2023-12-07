package Empresa;

import Controle.Menus;

/**
 * A classe App representa a aplicação principal do sistema da empresa. 
 * Contém o método main que inicia a execução do programa.
 * 
 * @author Igor Rosa
 * @version 1.0
 */
public class App {

    /**
     * Método principal que inicia a execução do programa.
     * 
     * @param args Argumentos de linha de comando (não utilizados).
     * @throws Exception Exceção que pode ser lançada durante a execução do programa.
     */
    public static void main(String[] args) throws Exception {
        Menus menu = new Menus(); // Instância da classe Menus para exibição de menus
        menu.menuInical();; // Chamada do método para exibir o menu inicial
    }
}
