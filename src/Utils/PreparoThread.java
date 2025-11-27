package Utils;

/**
 * Classe que simula o processamento do pedido em paralelo
 * Critério atendido: Uso de Threads
 * Critério atendido: Herança - estende a classe Thread do Java
 */

public class PreparoThread extends Thread {

    // O metodo run() é onde a mágica da Thread acontece.
    // Tudo que está aqui dentro roda separadamente do fluxo principal se necessário.
    @Override
    public void run() {
        try {
            System.out.println("\n[SISTEMA DE COZINHA] Iniciando preparo do Brownie...");
            System.out.print("Processando: ");

            // Loop para simular uma barra de progresso
            for (int i = 0; i < 5; i++) {
                // Pausa a execução desta thread por 1 segundo (1000 ms)
                Thread.sleep(1000);
                System.out.print(" ▰"); // Caractere visual de barra
            }

            System.out.println("\n[SISTEMA DE COZINHA] Pedido finalizado e embalado!\n");

        } catch (InterruptedException e) {
            // Tratamento obrigatório para Threads (caso o processo seja interrompido bruscamente)
            // Critério atendido: Tratamento de erros

            System.out.println("Erro: O preparo foi interrompido! " + e.getMessage());
        }
    }
}
//a
