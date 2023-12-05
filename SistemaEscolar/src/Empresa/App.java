package Empresa;

import Controle.*;
import Controle.GerenteGeral.Curso;
import Modelo.*;

public class App {
    public static void main(String[] args) throws Exception {

        BancoDeDados db = new BancoDeDados();

        Utilitarios util = new Utilitarios();
        GerenteGeral gerenteCurso= new GerenteGeral.Curso();
        gerenteCurso.Consultar();

        System.out.println("vamos trancar alex!");
    }
}
