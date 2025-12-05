package domain;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoVenda;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVenda = produto.getPreco();
    }

    public double getTotal() {
        return quantidade * precoVenda;
    }

    // Getter para impressão simples
    public String toString() {
        return produto.getNome() + " x " + quantidade + " = R$ " + getTotal();
    }
}