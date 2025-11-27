package Main;

import java.util.Scanner;
import java.util.InputMismatchException;

// Importamos nossas classes dos outros pacotes
import Model.*;
import Utils.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("=== BEM-VINDO À BROWNIES DAORA ===");

        // Loop principal do menu
        do {
            try {
                System.out.println("\nEscolha seu pedido:");
                System.out.println("1 - Brownie de Nutella");
                System.out.println("2 - Brownie de Doce de Leite");
                System.out.println("3 - Brownie de Chocolate");
                System.out.println("0 - Sair");
                System.out.print("Opção: ");

                opcao = scanner.nextInt();

                if (opcao == 0) {
                    System.out.println("Saindo... Volte sempre!");
                    break;
                }

                // Polimorfismo: Declaramos a variável do tipo genérico 'Produto'
                // mas instanciamos um tipo específico (Nutella, Doce de Leite, etc)
                Produto produtoEscolhido = null;

                switch (opcao) {
                    case 1:
                        produtoEscolhido = new BrownieNutella();
                        break;
                    case 2:
                        produtoEscolhido = new BrownieDoceDeLeite();
                        break;
                    case 3:
                        produtoEscolhido = new BrownieChocolate();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        continue; // Volta para o início do loop
                }

                // Se chegou aqui, temos um produto válido
                System.out.print("Digite a quantidade: ");
                int qtd = scanner.nextInt();

                // 1. Exibir detalhes (Polimorfismo em ação)
                produtoEscolhido.exibirDetalhes();

                // 2. Calcular total (Uso da Interface)
                double valorTotal = produtoEscolhido.calcularValorTotal(qtd);
                System.out.println("Valor Total: R$ " + String.format("%.2f", valorTotal));

                // 3. Iniciar a Thread de preparo (Critério 8 e 16)
                PreparoThread preparo = new PreparoThread();
                preparo.start();

                /* * O join() faz o programa principal "esperar" a Thread terminar
                 * para só depois salvar o arquivo. Isso sincroniza as coisas.
                 */
                try {
                    preparo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 4. Salvar no arquivo (Critério 7 e 15)
                String resumoVenda = "Produto: " + produtoEscolhido.getNome() +
                        " | Qtd: " + qtd +
                        " | Total: R$ " + valorTotal;

                GerenciadorDeArquivos.salvarVenda(resumoVenda);

            } catch (InputMismatchException e) {
                // Tratamento de erro (Critério 6 e 14): Caso o usuário digite letras onde deveria ser número
                System.out.println("\nERRO: Por favor, digite apenas números inteiros!");
                scanner.nextLine(); // Limpa o buffer do scanner para não travar num loop infinito
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }


        } while (opcao != 0);

        scanner.close();
    }
}