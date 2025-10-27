package model;

public class Sessao {
    private String horario;
    private int sala;
    private double precoBase;
    private String[][] assentos;

    public Sessao(String horario, int sala, double precoBase) {
        this.horario = horario;
        this.sala = sala;
        this.precoBase = precoBase;

        this.assentos = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.assentos[i][j] = "[ L ]";
            }
        }

    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void mostrarAssentos() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(this.assentos[i][j]);
            }
            System.out.println();
        }
    }

    public boolean reservarAssento(int linha, int coluna) throws exception.AssentoInvalidoException {
        if (linha < 0 || linha >= 5 || coluna < 0 || coluna >= 5) {
            throw new exception.AssentoInvalidoException("Assento inválido.");
        }
        if (!assentos[linha][coluna].equals("[ L ]")) {
            throw new exception.AssentoInvalidoException("Assento ocupado.");
        }
        this.assentos[linha][coluna] = "[ - ]";
        return true;
    }

    @Override
    public String toString() {
        return "Sala " + sala + " - " + horario + " - R$" + precoBase;
    }
}