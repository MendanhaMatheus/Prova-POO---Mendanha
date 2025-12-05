package entidades;
import java.util.UUID;
public class Produto
{
    private String id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    public Produto(String nome, double preco, int quantidadeEstoque)
    {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public boolean temEstoque(int quantidadeDesejada) {
        return this.quantidadeEstoque >= quantidadeDesejada;
    }
    public void baixarEstoque(int quantidade) {
        if (temEstoque(quantidade)) {
            this.quantidadeEstoque -= quantidade;
        }
    }
    public void reporEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }
}