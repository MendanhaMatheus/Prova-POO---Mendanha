package domain;

public abstract class Funcionario extends Pessoa {
    protected String matricula;

    public Funcionario(String nome, String telefone, String matricula) {
        super(nome, telefone);
        this.matricula = matricula;
    }
}