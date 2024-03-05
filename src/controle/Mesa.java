package controle;

import java.util.ArrayList;
import java.util.List;

class Mesa {
    private List<Pedido> pedidos;

    public Mesa() {
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(int indice) {
        pedidos.remove(indice);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public double calcularTotalConta() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularPrecoTotal();
        }
        return total;
    }
}

