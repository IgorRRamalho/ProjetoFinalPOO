package Modelo;

/**
 * A classe AlunoM representa um aluno, contendo informações pessoais como nome,
 * nome do pai, nome da mãe, RG, CPF,
 * data de nascimento, email, sexo, celular, e ID do curso ao qual está
 * vinculado, além de informações de endereço.
 * Esta classe herda da classe EnderecoM.
 * 
 * @author Giovanna Serejo
 * @version 1.0
 */
public class AlunoM extends EnderecoM {
    private String nome; // Nome do aluno
    private String nomePai; // Nome do pai do aluno
    private String nomeMae; // Nome da mãe do aluno
    private String rg; // Número do RG do aluno
    private String cpf; // Número do CPF do aluno
    private String dataNasc; // Data de nascimento do aluno
    private String email; // Endereço de email do aluno
    private char sexo; // Sexo do aluno (M - Masculino, F - Feminino)
    private String celular; // Número do celular do aluno
    private int IDcurso; // ID do curso ao qual o aluno está vinculado

    /**
     * Construtor para a classe AlunoM.
     * 
     * @param rua         Rua do endereço do aluno.
     * @param bairro      Bairro do endereço do aluno.
     * @param numero      Número do endereço do aluno.
     * @param complemento Complemento do endereço do aluno.
     * @param cep         CEP do endereço do aluno.
     * @param cidade      Cidade do endereço do aluno.
     * @param estado      Estado do endereço do aluno.
     * @param nome        Nome do aluno.
     * @param nomePai     Nome do pai do aluno.
     * @param nomeMae     Nome da mãe do aluno.
     * @param rg          Número do RG do aluno.
     * @param cpf         Número do CPF do aluno.
     * @param dataNasc    Data de nascimento do aluno.
     * @param email       Endereço de email do aluno.
     * @param sexo        Sexo do aluno (M - Masculino, F - Feminino).
     * @param celular     Número do celular do aluno.
     * @param IDcurso     ID do curso ao qual o aluno está vinculado.
     */
    public AlunoM(String rua, String bairro, int numero, String complemento, String cep, String cidade, String estado,
            String nome, String nomePai, String nomeMae, String rg, String cpf, String dataNasc, String email,
            char sexo, String celular, int IDcurso) {
        super(rua, bairro, numero, complemento, cep, cidade, estado);
        this.nome = nome;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.sexo = sexo;
        this.celular = celular;
        this.IDcurso = IDcurso;
    }

    /**
     * Obtém o nome do aluno.
     * 
     * @return O nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     * 
     * @param nome O novo nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nome do pai do aluno.
     * 
     * @return O nome do pai do aluno.
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * Define o nome do pai do aluno.
     * 
     * @param nomePai O novo nome do pai do aluno.
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * Obtém o nome da mãe do aluno.
     * 
     * @return O nome da mãe do aluno.
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Define o nome da mãe do aluno.
     * 
     * @param nomeMae O novo nome da mãe do aluno.
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * Obtém o número do RG do aluno.
     * 
     * @return O número do RG do aluno.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Define o número do RG do aluno.
     * 
     * @param rg O novo número do RG do aluno.
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Obtém o número do CPF do aluno.
     * 
     * @return O número do CPF do aluno.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o número do CPF do aluno.
     * 
     * @param cpf O novo número do CPF do aluno.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém a data de nascimento do aluno.
     * 
     * @return A data de nascimento do aluno.
     */
    public String getDataNasc() {
        return dataNasc;
    }

    /**
     * Define a data de nascimento do aluno.
     * 
     * @param dataNasc A nova data de nascimento do aluno.
     */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * Obtém o endereço de email do aluno.
     * 
     * @return O endereço de email do aluno.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do aluno.
     * 
     * @param email O novo endereço de email do aluno.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o sexo do aluno.
     * 
     * @return O sexo do aluno (M - Masculino, F - Feminino).
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Define o sexo do aluno.
     * 
     * @param sexo O novo sexo do aluno (M - Masculino, F - Feminino).
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtém o número do celular do aluno.
     * 
     * @return O número do celular do aluno.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Define o número do celular do aluno.
     * 
     * @param celular O novo número do celular do aluno.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtém o ID do curso ao qual o aluno está vinculado.
     * 
     * @return O ID do curso ao qual o aluno está vinculado.
     */
    public int getIDcurso() {
        return IDcurso;
    }

    /**
     * Define o ID do curso ao qual o aluno está vinculado.
     * 
     * @param IDcurso O novo ID do curso ao qual o aluno está vinculado.
     */
    public void setIDcurso(int IDcurso) {
        this.IDcurso = IDcurso;
    }
}
