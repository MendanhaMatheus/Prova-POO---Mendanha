package domain;

public class Empresa {
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private Endereco endereco;

    public Empresa(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}