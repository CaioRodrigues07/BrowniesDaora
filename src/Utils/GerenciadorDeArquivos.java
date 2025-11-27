package Utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitária responsável pela persistência de dados
 * Critério atendido: Leitura e escrita de arquivos
 */

public class GerenciadorDeArquivos {

    // Metodo estático: pode ser chamado sem dar 'new GerenciadorDeArquivos()'.
    public static void salvarVenda(String detalheVenda) {

        // Formata a data e hora atual para o registro ficar bonito no arquivo
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = dtf.format(LocalDateTime.now());

        // Monta a linha final que vai para o arquivo
        String linhaRegistro = "[" + dataHora + "] " + detalheVenda;

        /*
         * BLOCO TRY-WITH-RESOURCES
         * Critério atendido: 6 (Tratamento de erros).
         * Ao colocar o FileWriter dentro dos parênteses do try, o Java fecha o arquivo
         * automaticamente ao terminar, evitando erros de memória.
         * * O parâmetro 'true' no FileWriter(..., true) ativa o modo 'append',
         * ou seja, escreve no final do arquivo sem apagar o que já estava lá.
         */
        try (FileWriter fw = new FileWriter("vendas.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(linhaRegistro);
            System.out.println(">> Venda salva no arquivo 'vendas.txt' com sucesso.");

        } catch (IOException e) {
            // Se der erro (ex: disco cheio), o programa não trava, apenas avisa.
            System.err.println("ERRO CRÍTICO: Não foi possível salvar a venda no arquivo.");
            System.err.println("Detalhe do erro: " + e.getMessage());
        }
    }
}
//a
