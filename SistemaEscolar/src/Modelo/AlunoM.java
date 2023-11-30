package Modelo;


public class AlunoM {
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String rg;
    private String cpf;
    private String dataNasc;
    private String email;
    private char sexo;
    private String celular;
    private int id_curso;

    public AlunoM( String nome, String nomePai, String nomeMae, String rg, String cpf, String dataNasc, String email, char sexo, String celular, int id_curso) {
        this.nome = nome;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.sexo = sexo;
        this.celular = celular;
        this.id_curso = id_curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getId_Curso() {
        return id_curso;
    }

    public void setId_Curso(int id_curso) {
        this.id_curso = id_curso;
    }
    


    
}
