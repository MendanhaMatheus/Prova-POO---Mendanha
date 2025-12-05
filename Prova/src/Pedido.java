package domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Empresa empresa;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemPedido> itens;
    private TipoPagamento formaPagamento;
    private boolean aprovado;
    private static final double LIMITE_APROVACAO = 1000.00;

    public Pedido(Empresa empresa, Cliente cliente, Vendedor vendedor) {
        this.empresa = empresa;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = new ArrayList<>();
        this.aprovado = true;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.temEstoque(quantidade)) {
            itens.add(new ItemPedido(produto, quantidade));
            produto.baixarEstoque(quantidade);
            verificarNecessidadeAprovacao();
        }
    }

    public void setFormaPagamento(TipoPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    private void verificarNecessidadeAprovacao() {
        if (getValorTotal() > LIMITE_APROVACAO) {
            this.aprovado = false;
        }
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public String gerarRecibo() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- PEDIDO NA EMPRESA: ").append(empresa.getNomeFantasia()).append(" ---\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Vendedor: ").append(vendedor.getNome()).append("\n");
        sb.append("Status: ").append(aprovado ? "APROVADO" : "AGUARDANDO APROVAÇÃO SUPERVISOR").append("\n");
        sb.append("Itens:\n");
        for (ItemPedido item : itens) {
            sb.append("- ").append(item.getProduto().getNome())
                    .append(" | Qtd: ").append(item.getQuantidade())
                    .append(" | Sub: R$ ").append(String.format("%.2f", item.getSubtotal())).append("\n");
        }
        sb.append("TOTAL: R$ ").append(String.format("%.2f", getValorTotal()));
        return sb.toString();
    }
}