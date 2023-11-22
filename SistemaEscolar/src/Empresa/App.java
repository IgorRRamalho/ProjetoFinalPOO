package Empresa;
import Controle.BancoDeDados;
import Controle.Menu;
import Modelo.*;



public class App {
    public static void main(String[] args) throws Exception {
        
      BancoDeDados db = new BancoDeDados();
      Menu menu = new Menu();

      menu.menu();


      System.out.println("vamos trancar alex!");
    }
}
