import entidades.ItemCarrinho;
import entidades.Produto;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> estoque = new ArrayList<>();
        ArrayList<ItemCarrinho> carrinho = new ArrayList<>();

        estoque.add(new Produto("Arroz", 20.0, 10));
        estoque.add(new Produto("Feijao", 8.0, 20));
        estoque.add(new Produto("Macarrao", 5.0, 15));

        while (true)
        {
            System.out.println("\nMENU: 1. Comprar | 2. Finalizar | 3. Sair");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 3) break;

            if (opcao == 1) {

                System.out.println("--- PRODUTOS ---");
                for (Produto p : estoque) {
                    System.out.println("ID: " + p.getId() + " | " + p.getNome() + " | R$ " + p.getPreco());
                }

                System.out.print("Digite o ID do produto: ");
                String idBusca = scanner.nextLine();

                Produto produtoSelecionado = null;
                for (Produto p : estoque) {
                    if (p.getId().equals(idBusca)) {
                        produtoSelecionado = p;
                        break;
                    }
                }

                if (produtoSelecionado != null) {
                    System.out.print("Quantidade: ");
                    int qtd = Integer.parseInt(scanner.nextLine());

                    if (produtoSelecionado.temEstoque(qtd)) {
                        carrinho.add(new ItemCarrinho(produtoSelecionado, qtd));
                        System.out.println("Adicionado!");
                    } else {
                        System.out.println("Estoque insuficiente!");
                    }
                } else {
                    System.out.println("Produto não achado.");
                }

            } else if (opcao == 2) {
                // --- FINALIZAR ---
                double total = 0;
                System.out.println("--- CUPOM FISCAL ---");
                for (ItemCarrinho item : carrinho) {
                    System.out.println(item.getProduto().getNome() + " - R$ " + item.calcularSubtotal());
                    total += item.calcularSubtotal();
                    // Baixa o estoque agora
                    item.getProduto().baixarEstoque(item.getQuantidade());
                }
                System.out.println("TOTAL A PAGAR: R$ " + total);
                carrinho.clear(); // Limpa o carrinho
            }
        }
    }
}