package Modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A classe DocPagamentoM representa um documento de pagamento, contendo
 * informações como ID, situação,
 * valor, data de emissão e data de vencimento.
 * 
 * @author Giovanna Serejo
 * @version 1.0
 */
public class DocPagamentoM {
    private int docId;
    private int sitDoc;
    private BigDecimal valor;
    private Date emissao;
    private Date vencimento;

    /**
     * Construtor para a classe DocPagamentoM.
     * 
     * @param docId      O ID do documento de pagamento.
     * @param sitDoc     A situação do documento.
     * @param valor      O valor do pagamento.
     * @param emissao    A data de emissão do documento.
     * @param vencimento A data de vencimento do documento.
     */
    public DocPagamentoM(int docId, int sitDoc, BigDecimal valor, Date emissao, Date vencimento) {
        this.docId = docId;
        this.sitDoc = sitDoc;
        this.valor = valor;
        this.emissao = emissao;
        this.vencimento = vencimento;
    }

    /**
     * Obtém o ID do documento de pagamento.
     * 
     * @return O ID do documento de pagamento.
     */
    public int getDocId() {
        return docId;
    }

    /**
     * Define o ID do documento de pagamento.
     * 
     * @param docId O novo ID do documento de pagamento.
     */
    public void setDocId(int docId) {
        this.docId = docId;
    }

    /**
     * Obtém a situação do documento.
     * 
     * @return A situação do documento.
     */
    public int getSitDoc() {
        return sitDoc;
    }

    /**
     * Define a situação do documento.
     * 
     * @param sitDoc A nova situação do documento.
     */
    public void setSitDoc(int sitDoc) {
        this.sitDoc = sitDoc;
    }

    /**
     * Obtém o valor do pagamento.
     * 
     * @return O valor do pagamento.
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Define o valor do pagamento.
     * 
     * @param valor O novo valor do pagamento.
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * Obtém a data de emissão do documento.
     * 
     * @return A data de emissão do documento.
     */
    public Date getEmissao() {
        return emissao;
    }

    /**
     * Define a data de emissão do documento.
     * 
     * @param emissao A nova data de emissão do documento.
     */
    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    /**
     * Obtém a data de vencimento do documento.
     * 
     * @return A data de vencimento do documento.
     */
    public Date getVencimento() {
        return vencimento;
    }

    /**
     * Define a data de vencimento do documento.
     * 
     * @param vencimento A nova data de vencimento do documento.
     */
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
}
