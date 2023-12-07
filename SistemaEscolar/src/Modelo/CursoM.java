package Modelo;

/**
 * A classe CursoM representa um curso acadêmico, contendo informações como nome
 * do curso, turno, data de criação,
 * nota do MEC, quantidade de semestres, ID da educação mínima, ano de alteração
 * da grade, TCC (Trabalho de Conclusão
 * de Curso), créditos e horas complementares.
 * 
 * @author Brenno Otávo
 * @version 1.0
 */
public class CursoM {
    private String nomeCurso; // Nome do curso
    private String turno; // Turno do curso
    private String dataCriacao; // Data de criação do curso
    private int notaMec; // Nota do MEC do curso
    private int quantSemestres; // Quantidade de semestres do curso
    private int minEducacaoId; // ID da educação mínima para o curso
    private String anoAltGrade; // Ano de alteração da grade do curso
    private int tcc; // Indica se o curso possui Trabalho de Conclusão de Curso (TCC)
    private int creditos; // Número de créditos do curso
    private int horasComplementares; // Horas complementares obrigatórias do curso

    /**
     * Construtor para a classe CursoM.
     * 
     * @param nomeCurso           Nome do curso.
     * @param turno               Turno do curso.
     * @param dataCriacao         Data de criação do curso.
     * @param notaMec             Nota do MEC do curso.
     * @param quantSemestres      Quantidade de semestres do curso.
     * @param minEducacaoId       ID da educação mínima para o curso.
     * @param anoAltGrade         Ano de alteração da grade do curso.
     * @param tcc                 Indica se o curso possui TCC.
     * @param creditos            Número de créditos do curso.
     * @param horasComplementares Horas complementares obrigatórias do curso.
     */
    public CursoM(String nomeCurso, String turno, String dataCriacao, int notaMec, int quantSemestres,
            int minEducacaoId,
            String anoAltGrade, int tcc, int creditos, int horasComplementares) {
        this.nomeCurso = nomeCurso;
        this.turno = turno;
        this.dataCriacao = dataCriacao;
        this.notaMec = notaMec;
        this.quantSemestres = quantSemestres;
        this.minEducacaoId = minEducacaoId;
        this.anoAltGrade = anoAltGrade;
        this.tcc = tcc;
        this.creditos = creditos;
        this.horasComplementares = horasComplementares;
    }

    /**
     * Obtém o nome do curso.
     * 
     * @return O nome do curso.
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * Define o nome do curso.
     * 
     * @param nomeCurso O novo nome do curso.
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    /**
     * Obtém o turno do curso.
     * 
     * @return O turno do curso.
     */
    public String getTurno() {
        return turno;
    }

    /**
     * Define o turno do curso.
     * 
     * @param turno O novo turno do curso.
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * Obtém a data de criação do curso.
     * 
     * @return A data de criação do curso.
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Define a data de criação do curso.
     * 
     * @param dataCriacao A nova data de criação do curso.
     */
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * Obtém a nota do MEC do curso.
     * 
     * @return A nota do MEC do curso.
     */
    public int getNotaMec() {
        return notaMec;
    }

    /**
     * Define a nota do MEC do curso.
     * 
     * @param notaMec A nova nota do MEC do curso.
     */
    public void setNotaMec(int notaMec) {
        this.notaMec = notaMec;
    }

    /**
     * Obtém a quantidade de semestres do curso.
     * 
     * @return A quantidade de semestres do curso.
     */
    public int getQuantSemestres() {
        return quantSemestres;
    }

    /**
     * Define a quantidade de semestres do curso.
     * 
     * @param quantSemestres A nova quantidade de semestres do curso.
     */
    public void setQuantSemestres(int quantSemestres) {
        this.quantSemestres = quantSemestres;
    }

    /**
     * Obtém o ID da educação mínima para o curso.
     * 
     * @return O ID da educação mínima para o curso.
     */
    public int getMinEducacaoId() {
        return minEducacaoId;
    }

    /**
     * Define o ID da educação mínima para o curso.
     * 
     * @param minEducacaoId O novo ID da educação mínima para o curso.
     */
    public void setMinEducacaoId(int minEducacaoId) {
        this.minEducacaoId = minEducacaoId;
    }

    /**
     * Obtém o ano de alteração da grade do curso.
     * 
     * @return O ano de alteração da grade do curso.
     */
    public String getAnoAltGrade() {
        return anoAltGrade;
    }

    /**
     * Define o ano de alteração da grade do curso.
     * 
     * @param anoAltGrade O novo ano de alteração da grade do curso.
     */
    public void setAnoAltGrade(String anoAltGrade) {
        this.anoAltGrade = anoAltGrade;
    }

    /**
     * Obtém a indicação se o curso possui TCC.
     * 
     * @return A indicação se o curso possui TCC.
     */
    public int getTcc() {
        return tcc;
    }

    /**
     * Define se o curso possui TCC.
     * 
     * @param tcc A indicação se o curso possui TCC.
     */
    public void setTcc(int tcc) {
        this.tcc = tcc;
    }

    /**
     * Obtém o número de créditos do curso.
     * 
     * @return O número de créditos do curso.
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Define o número de créditos do curso.
     * 
     * @param creditos O novo número de créditos do curso.
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * Obtém as horas complementares obrigatórias do curso.
     * 
     * @return As horas complementares obrigatórias do curso.
     */
    public int getHorasComplementares() {
        return horasComplementares;
    }

    /**
     * Define as horas complementares obrigatórias do curso.
     * 
     * @param horasComplementares As novas horas complementares obrigatórias do
     *                            curso.
     */
    public void setHorasComplementares(int horasComplementares) {
        this.horasComplementares = horasComplementares;
    }
}
