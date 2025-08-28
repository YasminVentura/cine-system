package logicaDoSistema;

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

    public void mostrarAssentos() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(this.assentos[i][j]);
            }
            System.out.println();
        }
    }

    public boolean reservarAssento(int linha, int coluna) {
        if (linha >= 0 && linha < 5 && coluna >= 0 && coluna < 5){
            if (assentos[linha][coluna] == "[ L ]") {
                this.assentos[linha][coluna] = "[ - ]";
                return true;
            }
        }
        return false;
    }

    public double calcularPreco(int tipoIngresso) {
        if (tipoIngresso == 1) {
            return  precoBase * 0.4;
        } else {
            return precoBase;
        }
    }

    @Override
    public String toString() {
        return  "Sala " + sala + " - " + horario + " - R$" + precoBase;
    }
}
