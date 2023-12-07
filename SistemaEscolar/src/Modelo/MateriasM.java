package Modelo;

/**
 * A classe MateriasM representa uma disciplina ou matéria.
 * Contém o nome da matéria e métodos para acessar e modificar esse atributo.
 * 
 * @author Giovanna Serejo
 * @version 1.0
 */
public class MateriasM {

    // Atributos

    private String nomeMateria;

    /**
     * Construtor para inicializar uma instância da classe MateriasM.
     * 
     * @param nomeMateria O nome da disciplina ou matéria.
     */
    public MateriasM(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    // Métodos de Acesso

    /**
     * Obtém o nome da disciplina ou matéria.
     * 
     * @return O nome da disciplina ou matéria.
     */
    public String getNomeMateria() {
        return nomeMateria;
    }

    /**
     * Define o nome da disciplina ou matéria.
     * 
     * @param nomeMateria O nome da disciplina ou matéria.
     */
    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }
}
