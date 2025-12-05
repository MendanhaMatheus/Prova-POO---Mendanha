import domain.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Endereco endEmpresa = new Endereco("Av. Comercial", "100", "Centro", "Goiânia", "GO", "74000-000");
        Empresa empresa = new Empresa("Tecnologia LTDA", "TechStore", "12.345.678/0001-90", endEmpresa);

        Endereco endCliente = new Endereco("Rua das Flores", "20", "Jardim", "Goiânia", "GO", "74111-000");
        Cliente cliente = new Cliente("João Silva", "62999999999", "123.456.789-00", LocalDate.of(1990, 5, 15), endCliente);

        Vendedor vendedor = new Vendedor("Maria Souza", "62988888888", "V001");
        Supervisor supervisor = new Supervisor("Carlos Chefe", "62977777777", "S001");

        Fabricante fabDell = new Fabricante("Dell");
        Categoria catInformatica = new Categoria("Informática");
        Subcategoria subNotebook = new Subcategoria("Notebooks", catInformatica);

        Produto p1 = new Produto("Notebook XPS", "Alta performance", 5000.00, 10, catInformatica, subNotebook, fabDell);
        Produto p2 = new Produto("Mouse Wireless", "Mouse óptico", 150.00, 50, catInformatica, subNotebook, fabDell);

        Pedido pedido = new Pedido(empresa, cliente, vendedor);

        pedido.adicionarItem(p1, 1);
        pedido.adicionarItem(p2, 2);

        pedido.setFormaPagamento(TipoPagamento.CARTAO_CREDITO);

        System.out.println(pedido.gerarRecibo());

        if (!pedido.isAprovado()) {
            System.out.println("\n[SISTEMA] Valor excedeu limite. Solicitando aprovação do supervisor...");
            supervisor.aprovarPedido(pedido);
            System.out.println("[SISTEMA] Pedido aprovado por: " + supervisor.getNome());
        }

        System.out.println("\n>>> RECIBO FINAL <<<");
        System.out.println(pedido.gerarRecibo());
    }
}