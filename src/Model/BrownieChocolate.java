package Model;

public class BrownieChocolate extends Produto {
    public BrownieChocolate() {
        super("Brownie Puro Chocolate", 7.00);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- DETALHES DO PRODUTO ---");
        System.out.println("Sabor: " + this.nome);
        System.out.println("Preço: R$ " + this.precoUnitario);
        System.out.println("Descrição: Para os amantes de cacau, massa escura e gotas de chocolate.");
    }
}
//a
