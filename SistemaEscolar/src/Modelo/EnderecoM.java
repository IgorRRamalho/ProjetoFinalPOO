package Modelo;

/**
 * A classe EnderecoM representa informações de endereço, como rua, bairro, número, complemento, CEP, cidade e estado.
 * Essa classe fornece métodos para acessar e modificar essas informações.
 * 
 * @author Igor Rosa
 * @version 1.0
 */
public class EnderecoM {
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

    /**
     * Construtor para a classe EnderecoM.
     * 
     * @param rua         O nome da rua.
     * @param bairro      O nome do bairro.
     * @param numero      O número do endereço.
     * @param complemento Informações adicionais sobre o endereço.
     * @param cep         O CEP do endereço.
     * @param cidade      O nome da cidade.
     * @param estado      O estado do endereço.
     */
    public EnderecoM(String rua, String bairro, int numero, String complemento, String cep, String cidade,
            String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    /**
     * Obtém o nome da rua.
     * 
     * @return O nome da rua.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Define o nome da rua.
     * 
     * @param rua O novo nome da rua.
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Obtém o nome do bairro.
     * 
     * @return O nome do bairro.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o nome do bairro.
     * 
     * @param bairro O novo nome do bairro.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém o número do endereço.
     * 
     * @return O número do endereço.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número do endereço.
     * 
     * @param numero O novo número do endereço.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtém informações adicionais sobre o endereço.
     * 
     * @return Informações adicionais sobre o endereço.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define informações adicionais sobre o endereço.
     * 
     * @param complemento As novas informações adicionais sobre o endereço.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Obtém o CEP do endereço.
     * 
     * @return O CEP do endereço.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o CEP do endereço.
     * 
     * @param cep O novo CEP do endereço.
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Obtém o nome da cidade.
     * 
     * @return O nome da cidade.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define o nome da cidade.
     * 
     * @param cidade O novo nome da cidade.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém o estado do endereço.
     * 
     * @return O estado do endereço.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado do endereço.
     * 
     * @param estado O novo estado do endereço.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
