package domain;

public class Produto {
    private String nome;
    private double preco;
    private Subcategoria subcategoria;
    private Fabricante fabricante;

    public Produto(String nome, double preco, Subcategoria subcategoria, Fabricante fabricante) {
        this.nome = nome;
        this.preco = preco;
        this.subcategoria = subcategoria;
        this.fabricante = fabricante;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}