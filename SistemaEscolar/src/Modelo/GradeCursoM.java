package Modelo;

/**
 * A classe GradeCursoM representa a associação entre um curso e uma matéria em
 * uma grade curricular.
 * Contém os identificadores únicos do curso e da matéria.
 * 
 * @author Iury Gabriel
 * @version 1.0
 */
public class GradeCursoM {

    // Atributos

    private int cursoId;
    private int materiaId;

    /**
     * Construtor para inicializar uma instância da classe GradeCursoM.
     * 
     * @param cursoId   Identificador único do curso.
     * @param materiaId Identificador único da matéria.
     */
    public GradeCursoM(int cursoId, int materiaId) {
        this.cursoId = cursoId;
        this.materiaId = materiaId;
    }

    // Métodos de Acesso

    /**
     * Obtém o identificador único do curso.
     * 
     * @return O identificador único do curso.
     */
    public int getCursoId() {
        return cursoId;
    }

    /**
     * Define o identificador único do curso.
     * 
     * @param cursoId O identificador único do curso.
     */
    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    /**
     * Obtém o identificador único da matéria.
     * 
     * @return O identificador único da matéria.
     */
    public int getMateriaId() {
        return materiaId;
    }

    /**
     * Define o identificador único da matéria.
     * 
     * @param materiaId O identificador único da matéria.
     */
    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }
}
