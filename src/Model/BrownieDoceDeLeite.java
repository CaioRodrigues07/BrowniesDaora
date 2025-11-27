package Model;

public class BrownieDoceDeLeite extends Produto {

    public BrownieDoceDeLeite() {
        // Define nome e um preço diferente
        super("Brownie de Doce de Leite", 8.50);
    }
//a
    @Override
    public void exibirDetalhes() {
        System.out.println("--- DETALHES DO PRODUTO ---");
        System.out.println("Sabor: " + this.nome);
        System.out.println("Preço: R$ " + this.precoUnitario);
        System.out.println("Descrição: O clássico brownie com cobertura de Doce de Leite mineiro.");
    }
}

