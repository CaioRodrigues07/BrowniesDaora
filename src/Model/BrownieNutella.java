package Model;

public class BrownieNutella extends Produto{
    public BrownieNutella() {
        // 'super' Chama o construtor da classe pai (Produto)
        super("Brownie de Nutella", 10.00);
    }
//a
    @Override
    public void exibirDetalhes() {
        System.out.println("--- DETALHES DO PRODUTO ---");
        System.out.println("Sabor: " + this.nome);
        System.out.println("Preço: R$ " + this.precoUnitario);
        System.out.println("Descrição: Delicioso brownie recheado com muuita Nutella.");
    }
}
