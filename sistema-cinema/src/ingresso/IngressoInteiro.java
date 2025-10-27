package ingresso;

public class IngressoInteiro extends Ingresso {

    public IngressoInteiro(double precoBase) {
        super(precoBase);
    }

    @Override
    public double calcularPreco() {
        return precoBase;
    }

    @Override
    public String toString() {
        return String.format("Ingresso Inteiro - R$ %.2f", calcularPreco());
    }
}