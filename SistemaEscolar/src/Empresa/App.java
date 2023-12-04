package Empresa;

import Controle.*;
import Controle.GerenteGeral.Curso;
import Modelo.*;

public class App {
    public static void main(String[] args) throws Exception {

        BancoDeDados db = new BancoDeDados();

        Utilitarios util = new Utilitarios();
        GerenteGeral.Aluno AlunoC = new GerenteGeral().new Aluno();
        GerenteGeral.Curso CursoC = new GerenteGeral().new Curso();
        GerenteGeral.Materias MateriasC = new GerenteGeral().new Materias();

        // int idaluno = util.getIDaluno("07341691166");

        // System.out.println(idaluno);

        MateriasC.Inserir();
        CursoC.Inserir();
        AlunoC.Inserir();

        /*
         * Uso de polimorfismo de tempo de execução
         * Animal meuAnimal = new Cachorro();
         * meuAnimal.fazerSom(); // Chama o método fazerSom() de Cachorro
         */

        System.out.println("vamos trancar alex!");
    }
}
