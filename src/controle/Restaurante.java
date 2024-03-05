package controle;

import java.util.HashMap;
import java.util.Map;

public class Restaurante {
    private Mesa[] mesas;
    private Map<Integer, Produto> cardapio;

    public Restaurante(int numMesas) {
        this.mesas = new Mesa[numMesas];
        for (int i = 0; i < numMesas; i++) {
            mesas[i] = new Mesa();
        }
        this.cardapio = new HashMap<>();
        inicializarCardapio();
    }

    private void inicializarCardapio() {
        cardapio.put(1, new Produto(1, "Refeição", 20.0));
        cardapio.put(2, new Produto(2, "Bebida", 5.0));
        cardapio.put(3, new Produto(3, "Sobremesa", 8.0));
    }

    public void adicionarPedido(int numMesa, int codigoProduto, int quantidade) {
        Produto produto = cardapio.get(codigoProduto);
        if (produto != null) {
            mesas[numMesa].adicionarPedido(new Pedido(produto, quantidade));
        } else {
            System.out.println("Produto não encontrado no cardápio.");
        }
    }

    public void removerPedido(int numMesa, int indicePedido) {
        mesas[numMesa].removerPedido(indicePedido);
    }

    public void fecharConta(int numMesa) {
        Mesa mesa = mesas[numMesa];
        double totalConta = mesa.calcularTotalConta();
        double gorjeta = totalConta * 0.1;
        double totalComGorjeta = totalConta + gorjeta;

        System.out.println("Resumo da Conta - Mesa " + (numMesa + 1));
        for (Pedido pedido : mesa.getPedidos()) {
            System.out.println(pedido.getProduto().getNome() + " - Quantidade: " + pedido.getQuantidade() +
                    " - Preço Total: " + pedido.calcularPrecoTotal());
        }
        System.out.println("Total da Conta: " + totalConta);
        System.out.println("Gorjeta (10%): " + gorjeta);
        System.out.println("Total com Gorjeta: " + totalComGorjeta);
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante(10);
        restaurante.adicionarPedido(0, 1, 2); // Refeição
        restaurante.adicionarPedido(0, 2, 3); // Bebida
        restaurante.adicionarPedido(0, 3, 1); // Sobremesa

        restaurante.fecharConta(0);
    }
}

