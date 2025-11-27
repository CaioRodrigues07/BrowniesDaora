package Interface;

/**
 * Interface que define o comportamento de qualquer item vendável.
 */

public interface Vendavel {

    // Metodo que calcula o preço baseado na quantidade

    public double calcularValorTotal(int quantidade);
}
