package logicaDoSistema;

import java.util.List;
import java.util.Scanner;


public class SistemaIngressos {
    private List<Filme> filmes;

    public SistemaIngressos(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void listarFilmes() {
        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }

    public void efetuarCompra(Scanner sc) {
        int resp, salaEscolhida, linha, coluna, tipoIngresso;

        while (true) {
            System.out.println("\nQual filme deseja asistir?");
            for (int i = 0; i < this.filmes.size(); i++) {
                System.out.printf("[%d] %s\n", i,  filmes.get(i).getTitulo());
            }
            System.out.println("[-1] Sair\n");

            resp = sc.nextInt();
            sc.nextLine();

            if (resp == -1) {
                System.out.print("Até mais!");
                break;
            }

            if (resp >= filmes.size() || resp < -1) {
                System.out.println("Valor inválido! Tente novamente\n");
                continue;
            }

            System.out.printf("\n%s - Escolha a sessão [0 a %d]:\n", filmes.get(resp).getTitulo(), filmes.get(resp).getSessoes().size()-1);
            System.out.println(filmes.get(resp).getSessoes());
            System.out.println();

            salaEscolhida = sc.nextInt();
            sc.nextLine();

            if (salaEscolhida >= filmes.get(resp).getSessoes().size() || salaEscolhida < 0) {
                System.out.println("Valor inválido! Tente novamente\n");
                continue;
            }

            System.out.println("\nEscolha o assento informando a linha e a coluna [0 a 4]:");
            while (true) {
                filmes.get(resp).getSessoes().get(salaEscolhida).mostrarAssentos();
                System.out.println();

                linha = sc.nextInt();
                coluna = sc.nextInt();
                sc.nextLine();

                if (filmes.get(resp).getSessoes().get(salaEscolhida).reservarAssento(linha, coluna)) {
                    break;
                } else {
                    System.out.println("Assento ocupado ou inválido. Tente novamente!\n");
                }
            }

            do {
                System.out.println("\nTipo de ingresso? [inteiro = 0 / estudante = 1]\n");
                tipoIngresso = sc.nextInt();
                sc.nextLine();
            } while (tipoIngresso != 0 && tipoIngresso != 1);

            var valorIngresso = filmes.get(resp).getSessoes().get(salaEscolhida).calcularPreco(tipoIngresso);

            System.out.println("\n______________________________________________\n");
            System.out.println("Compra Confirmada! Informações: ");
            System.out.printf("%s - %s\nValor a pagar: %.2f\n", filmes.get(resp).getTitulo(), filmes.get(resp).getSessoes().get(salaEscolhida), valorIngresso);
            System.out.println("\n______________________________________________\n");

        }

    }

}
