package Modelo;

/**
 * A classe HistoricoM representa o histórico de um aluno em uma disciplina específica.
 * Contém informações como o identificador do aluno, o identificador da matéria,
 * notas das provas e quantidade de faltas.
 * 
 * @author Daniel Porto
 * @version 1.0
 */
public class HistoricoM {

    // Atributos

    private int alunoId;
    private int materiaId;
    private float prova1;
    private float prova2;
    private int faltas;

    /**
     * Construtor para inicializar uma instância da classe HistoricoM.
     * 
     * @param alunoId   Identificador único do aluno.
     * @param materiaId Identificador único da matéria.
     * @param prova1    Nota da primeira prova.
     * @param prova2    Nota da segunda prova.
     * @param faltas    Quantidade de faltas do aluno na matéria.
     */
    public HistoricoM(int alunoId, int materiaId, float prova1, float prova2, int faltas) {
        this.alunoId = alunoId;
        this.materiaId = materiaId;
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.faltas = faltas;
    }

    // Métodos de Acesso

    /**
     * Obtém o identificador único do aluno.
     * 
     * @return O identificador único do aluno.
     */
    public int getAlunoId() {
        return alunoId;
    }

    /**
     * Define o identificador único do aluno.
     * 
     * @param alunoId O identificador único do aluno.
     */
    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
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

    /**
     * Obtém a nota da primeira prova.
     * 
     * @return A nota da primeira prova.
     */
    public float getProva1() {
        return prova1;
    }

    /**
     * Define a nota da primeira prova.
     * 
     * @param prova1 A nota da primeira prova.
     */
    public void setProva1(float prova1) {
        this.prova1 = prova1;
    }

    /**
     * Obtém a nota da segunda prova.
     * 
     * @return A nota da segunda prova.
     */
    public float getProva2() {
        return prova2;
    }

    /**
     * Define a nota da segunda prova.
     * 
     * @param prova2 A nota da segunda prova.
     */
    public void setProva2(float prova2) {
        this.prova2 = prova2;
    }

    /**
     * Obtém a quantidade de faltas do aluno na matéria.
     * 
     * @return A quantidade de faltas do aluno.
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * Define a quantidade de faltas do aluno na matéria.
     * 
     * @param faltas A quantidade de faltas do aluno.
     */
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
}
