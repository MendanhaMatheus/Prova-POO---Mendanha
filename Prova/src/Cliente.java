package domain;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String telefone, String cpf, LocalDate dataNascimento, Endereco endereco) {
        super(nome, telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
}