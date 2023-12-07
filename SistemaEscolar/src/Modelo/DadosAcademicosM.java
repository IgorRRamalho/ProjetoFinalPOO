package Modelo;

/**
 * A classe DadosAcademicosM representa informações acadêmicas associadas a um
 * aluno, incluindo o ID do aluno
 * e o ID do curso ao qual está vinculado.
 * 
 * Esta classe é utilizada para armazenar dados acadêmicos específicos de um
 * aluno.
 * 
 * @author Daniel Porto
 * @version 1.0
 */
public class DadosAcademicosM {
    private int alunoId; // ID único do aluno
    private int cursoId; // ID do curso associado ao aluno

    /**
     * Construtor para a classe DadosAcademicosM.
     * 
     * @param alunoId O ID do aluno.
     * @param cursoId O ID do curso associado ao aluno.
     */
    public DadosAcademicosM(int alunoId, int cursoId) {
        this.alunoId = alunoId;
        this.cursoId = cursoId;
    }

    /**
     * Obtém o ID do aluno.
     * 
     * @return O ID do aluno.
     */
    public int getAlunoId() {
        return alunoId;
    }

    /**
     * Define o ID do aluno.
     * 
     * @param alunoId O novo ID do aluno.
     */
    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    /**
     * Obtém o ID do curso associado ao aluno.
     * 
     * @return O ID do curso associado ao aluno.
     */
    public int getCursoId() {
        return cursoId;
    }

    /**
     * Define o ID do curso associado ao aluno.
     * 
     * @param cursoId O novo ID do curso associado ao aluno.
     */
    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }
}
