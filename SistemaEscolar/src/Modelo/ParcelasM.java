package Modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A classe ParcelasM representa as parcelas associadas a um documento de pagamento, incluindo informações como
 * ID do aluno, ano/mês da parcela e semestre da parcela.
 * 
 * Esta classe estende a classe DocPagamentoM para herdar as propriedades básicas de um documento de pagamento.
 * 
 * @author Iury Gabriel
 * @version 1.0
 */
public class ParcelasM extends DocPagamentoM {
    private int alunoId;
    private String anomesParc;

    /**
     * Construtor para a classe ParcelasM.
     * 
     * @param docId         O ID do documento de pagamento.
     * @param sitDoc        A situação do documento.
     * @param valor         O valor do pagamento.
     * @param emissao       A data de emissão do documento.
     * @param vencimento    A data de vencimento do documento.
     * @param alunoId       O ID do aluno associado à parcela.
     * @param anomesParc    A data representando o ano/mês da parcela.
     */
    public ParcelasM(int docId, int sitDoc, BigDecimal valor, Date emissao, Date vencimento, int alunoId,
            String anomesParc) {
        super(docId, sitDoc, valor, emissao, vencimento);
        this.alunoId = alunoId;
        this.anomesParc = anomesParc;
    }

    /**
     * Obtém o ID do aluno associado à parcela.
     * 
     * @return O ID do aluno associado à parcela.
     */
    public int getAlunoId() {
        return alunoId;
    }

    /**
     * Define o ID do aluno associado à parcela.
     * 
     * @param alunoId O novo ID do aluno associado à parcela.
     */
    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    /**
     * Obtém a data representando o ano/mês da parcela.
     * 
     * @return A data representando o ano/mês da parcela.
     */
    public String getAnomesParc() {
        return anomesParc;
    }

    /**
     * Define a data representando o ano/mês da parcela.
     * 
     * @param anomesParc A nova data representando o ano/mês da parcela.
     */
    public void setAnomesParc(String anomesParc) {
        this.anomesParc = anomesParc;
    }
}
