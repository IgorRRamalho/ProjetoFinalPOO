package Empresa;
import Controle.*;

import Modelo.*;



public class App {
    public static void main(String[] args) throws Exception {
        
      BancoDeDados db = new BancoDeDados();
      Menus menuu = new Menus();
      CursoC controle = new CursoC();

      db.abrirConexao();

      menuu.menuInical();


    CursoM adm = new CursoM(0, null, null, null, 0, 0, 0, null, 0, 0, 0, 0);

    controle.AtualizaNomeDoCurso(null, 0);

    System.out.println("vamos trancar alex!");
    }
}
