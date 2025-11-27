package Model;
import Interface.Vendavel;

public abstract class Produto implements Vendavel {
    // 'protected': Permite que as classes filhas (Brownies) acessem estas variáveis diretamente.
    protected String nome;
    protected double precoUnitario;

    // Construtor
    public Produto(String nome, double preco){
        this.nome = nome;
        this.precoUnitario = preco;
    }

    // Getters para acessar os dados de fora se necessário
    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }


    // Implementação da interface Vendavel.
    @Override
    public double calcularValorTotal(int quantidade) {
        return this.precoUnitario * quantidade;
    }

    //Metodo Abstrato: Ele OBRIGA cada brownie específico a criar sua própria mensagem
    public abstract void exibirDetalhes();
}
//a
