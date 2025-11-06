package service;

import model.Filme;
import model.Sessao;
import ingresso.Ingresso;
import ingresso.IngressoEstudante;
import ingresso.IngressoInteiro;
import ingresso.IngressoVip;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

import exception.AssentoInvalidoException;
import exception.ValorEntradaInvalidoException;

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
        int resp, salaEscolhida, linha, coluna;

        while (true) {
            try {
                int tipoIngresso = -1;
                System.out.println("\nQual filme deseja assistir?");
                for (int i = 0; i < this.filmes.size(); i++) {
                    System.out.printf("[%d] %s\n", i, filmes.get(i).getTitulo());
                }
                System.out.println("[-1] Sair\n");

                try {
                    resp = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Tente novamente.");
                    sc.nextLine();
                    continue;
                }

                if (resp == -1) {
                    System.out.print("Até mais!");
                    break;
                }

                if (resp >= filmes.size() || resp < -1) {
                    throw new exception.ValorEntradaInvalidoException("Valor inválido! Tente novamente");
                }

                System.out.printf("\n%s - Escolha a sessão:\n", filmes.get(resp).getTitulo());

                List<Sessao> sessoes = filmes.get(resp).getSessoes();
                for (int i = 0; i < sessoes.size(); i++) {
                    System.out.println("[" + i + "] " + sessoes.get(i));
                }

                salaEscolhida = sc.nextInt();
                sc.nextLine();

                if (salaEscolhida >= sessoes.size() || salaEscolhida < 0) {
                    throw new exception.ValorEntradaInvalidoException("Valor inválido! Tente novamente");
                }

                Sessao sessaoEscolhida = sessoes.get(salaEscolhida);
                System.out.println("\nEscolha o assento informando a linha e a coluna [0 a 4]:");

                while (true) {
                    sessaoEscolhida.mostrarAssentos();
                    System.out.println();

                    linha = sc.nextInt();
                    coluna = sc.nextInt();
                    sc.nextLine();
                    try {
                        sessaoEscolhida.reservarAssento(linha, coluna);
                        break;
                    } catch (AssentoInvalidoException e) {
                        System.out.println(e.getMessage() + " Tente novamente!\n");
                    }
                }

                do {
                    try {
                        System.out.println("\nQual o tipo do ingresso?\n[0] Inteiro\n[1] Estudante\n[2] VIP\n");
                        int tipoIngressoTemp = sc.nextInt();
                        sc.nextLine();
                        if (tipoIngressoTemp < 0 || tipoIngressoTemp > 2) {
                            throw new exception.ValorEntradaInvalidoException("Valor inválido! Tente novamente");
                        } else {
                            tipoIngresso = tipoIngressoTemp;
                        }
                    } catch (exception.ValorEntradaInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
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
            } catch (ValorEntradaInvalidoException | InputMismatchException e) {
                System.out.println("Entrada inválida! Tente novamente.");
            }
        }
    }
}