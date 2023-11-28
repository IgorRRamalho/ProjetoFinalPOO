package Empresa;
import Controle.*;


import Modelo.*;



public class App {
    public static void main(String[] args) throws Exception {
        
      BancoDeDados db = new BancoDeDados();

      CursoC controle = new CursoC();
      Gerenciamento.Curso CursoC = new Gerenciamento().new Curso();
      Gerenciamento.Aluno AlunoC = new Gerenciamento().new Aluno();
      Gerenciamento.Materias MateriaC = new Gerenciamento().new Materias();

     /*
 * // Uso de polimorfismo de tempo de execução
 * Animal meuAnimal = new Cachorro();
 * meuAnimal.fazerSom(); // Chama o método fazerSom() de Cachorro
 */

 

    System.out.println("vamos trancar alex!");
    }
}
