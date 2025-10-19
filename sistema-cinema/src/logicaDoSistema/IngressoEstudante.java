package logicaDoSistema;

public class IngressoEstudante extends Ingresso {

    public IngressoEstudante(double precoBase) {
        super(precoBase);
    }

    @Override
    public double calcularPreco() {
        return precoBase * 0.4;
    }

    @Override
    public String toString() {
        return String.format("Ingresso Estudante - R$ %.2f", calcularPreco());
    }
}
