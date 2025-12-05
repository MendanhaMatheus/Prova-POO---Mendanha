package domain;

public class Supervisor extends Funcionario {
    public Supervisor(String nome, String telefone, String matricula) {
        super(nome, telefone, matricula);
    }

    public void aprovarPedido(Pedido pedido) {
        pedido.setAprovado(true);
    }
}