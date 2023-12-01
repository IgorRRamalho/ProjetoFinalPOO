package Empresa;

import Controle.*;
import Controle.Gerenciamento.Curso;
import Modelo.*;

public class App {
    public static void main(String[] args) throws Exception {

        BancoDeDados db = new BancoDeDados();

        Utilitarios util = new Utilitarios();
        Gerenciamento.Aluno AlunoC = new Gerenciamento().new Aluno();
        Gerenciamento.Curso CursoC = new Gerenciamento().new Curso();
        Gerenciamento.Materias MateriasC = new Gerenciamento().new Materias();

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
