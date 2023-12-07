package Modelo;

/**
 * A classe OrigemM representa as informações de origem de um aluno.
 * Inclui dados como histórico do Ensino Médio, reservista, comprovante de residência, etc.
 * 
 * @author Igor Rosa
 * @version 1.0
 */
public class OrigemM {

    // Atributos

    private int alunoId;
    private int historicoEm;
    private int reservista;
    private int compResidencia;
    private String colegioAntigo;
    private int eja;
    private int ensinoTecnico;

    /**
     * Construtor para inicializar uma instância da classe OrigemM.
     * 
     * @param alunoId          Identificador único do aluno.
     * @param historicoEm      Indica se o aluno possui histórico do Ensino Médio.
     * @param reservista       Indica se o aluno possui reservista.
     * @param compResidencia   Indica se o aluno possui comprovante de residência.
     * @param colegioAntigo    Nome do colégio anterior do aluno.
     * @param eja              Indica se o aluno participou da Educação de Jovens e Adultos (EJA).
     * @param ensinoTecnico    Indica se o aluno concluiu o Ensino Técnico.
     */
    public OrigemM(int alunoId, int historicoEm, int reservista, int compResidencia, String colegioAntigo, int eja, int ensinoTecnico) {
        this.alunoId = alunoId;
        this.historicoEm = historicoEm;
        this.reservista = reservista;
        this.compResidencia = compResidencia;
        this.colegioAntigo = colegioAntigo;
        this.eja = eja;
        this.ensinoTecnico = ensinoTecnico;
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
     * Obtém a indicação sobre a presença de histórico do Ensino Médio.
     * 
     * @return 1 se o aluno possui histórico do Ensino Médio, 0 caso contrário.
     */
    public int getHistoricoEm() {
        return historicoEm;
    }

    /**
     * Define a presença ou ausência de histórico do Ensino Médio.
     * 
     * @param historicoEm 1 se o aluno possui histórico do Ensino Médio, 0 caso contrário.
     */
    public void setHistoricoEm(int historicoEm) {
        this.historicoEm = historicoEm;
    }

    /**
     * Obtém a indicação sobre a posse de reservista.
     * 
     * @return 1 se o aluno possui reservista, 0 caso contrário.
     */
    public int getReservista() {
        return reservista;
    }

    /**
     * Define a posse ou ausência de reservista.
     * 
     * @param reservista 1 se o aluno possui reservista, 0 caso contrário.
     */
    public void setReservista(int reservista) {
        this.reservista = reservista;
    }

    /**
     * Obtém a indicação sobre a posse de comprovante de residência.
     * 
     * @return 1 se o aluno possui comprovante de residência, 0 caso contrário.
     */
    public int getCompResidencia() {
        return compResidencia;
    }

    /**
     * Define a posse ou ausência de comprovante de residência.
     * 
     * @param compResidencia 1 se o aluno possui comprovante de residência, 0 caso contrário.
     */
    public void setCompResidencia(int compResidencia) {
        this.compResidencia = compResidencia;
    }

    /**
     * Obtém o nome do colégio anterior do aluno.
     * 
     * @return O nome do colégio anterior do aluno.
     */
    public String getColegioAntigo() {
        return colegioAntigo;
    }

    /**
     * Define o nome do colégio anterior do aluno.
     * 
     * @param colegioAntigo O nome do colégio anterior do aluno.
     */
    public void setColegioAntigo(String colegioAntigo) {
        this.colegioAntigo = colegioAntigo;
    }

    /**
     * Obtém a indicação sobre a participação do aluno na Educação de Jovens e Adultos (EJA).
     * 
     * @return 1 se o aluno participou da EJA, 0 caso contrário.
     */
    public int getEja() {
        return eja;
    }

    /**
     * Define a participação ou ausência do aluno na Educação de Jovens e Adultos (EJA).
     * 
     * @param eja 1 se o aluno participou da EJA, 0 caso contrário.
     */
    public void setEja(int eja) {
        this.eja = eja;
    }

    /**
     * Obtém a indicação sobre a conclusão do Ensino Técnico pelo aluno.
     * 
     * @return 1 se o aluno concluiu o Ensino Técnico, 0 caso contrário.
     */
    public int getEnsinoTecnico() {
        return ensinoTecnico;
    }

    /**
     * Define a conclusão ou ausência do Ensino Técnico pelo aluno.
     * 
     * @param ensinoTecnico 1 se o aluno concluiu o Ensino Técnico, 0 caso contrário.
     */
    public void setEnsinoTecnico(int ensinoTecnico) {
        this.ensinoTecnico = ensinoTecnico;
    }
}
