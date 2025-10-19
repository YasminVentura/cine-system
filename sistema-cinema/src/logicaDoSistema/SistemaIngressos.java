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
            System.out.println("\nQual filme deseja assistir?");
            for (int i = 0; i < this.filmes.size(); i++) {
                System.out.printf("[%d] %s\n", i, filmes.get(i).getTitulo());
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

            System.out.printf("\n%s - Escolha a sessão:\n", filmes.get(resp).getTitulo());

            List<Sessao> sessoes = filmes.get(resp).getSessoes();
            for (int i = 0; i < sessoes.size(); i++) {
                System.out.println("[" + i + "] " + sessoes.get(i));
            }

            salaEscolhida = sc.nextInt();
            sc.nextLine();

            if (salaEscolhida >= sessoes.size() || salaEscolhida < 0) {
                System.out.println("Valor inválido! Tente novamente\n");
                continue;
            }

            Sessao sessaoEscolhida = sessoes.get(salaEscolhida);
            System.out.println("\nEscolha o assento informando a linha e a coluna [0 a 4]:");

            while (true) {
                sessaoEscolhida.mostrarAssentos();
                System.out.println();

                linha = sc.nextInt();
                coluna = sc.nextInt();
                sc.nextLine();

                if (sessaoEscolhida.reservarAssento(linha, coluna)) {
                    break;
                } else {
                    System.out.println("Assento ocupado ou inválido. Tente novamente!\n");
                }
            }

            do {
                System.out.println("\nTipo de ingresso? [0=inteiro / 1=estudante / 2=vip]\n");
                tipoIngresso = sc.nextInt();
                sc.nextLine();
            } while (tipoIngresso < 0 || tipoIngresso > 2);

            double precoBase = sessaoEscolhida.getPrecoBase();
            Ingresso ingresso = tipoIngresso == 0
                    ? new IngressoInteiro(precoBase)
                    : tipoIngresso == 1
                            ? new IngressoEstudante(precoBase)
                            : new IngressoVip(precoBase);

            double valorIngresso = ingresso.calcularPreco();

            System.out.println("\n______________________________________________\n");
            System.out.println("Compra Confirmada! Informações: ");
            System.out.printf("%s - %s\n%s\nValor a pagar: R$ %.2f\n",
                    filmes.get(resp).getTitulo(),
                    sessaoEscolhida,
                    ingresso,
                    valorIngresso);
            System.out.println("\n______________________________________________\n");
        }
    }
}
