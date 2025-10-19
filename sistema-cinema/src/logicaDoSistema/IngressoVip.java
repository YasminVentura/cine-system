package logicaDoSistema;

public class IngressoVip extends Ingresso {

    public IngressoVip(double precoBase) {
        super(precoBase);
    }

    @Override
    public double calcularPreco() {
        return precoBase * 1.2;
    }

    @Override
    public String toString() {
        return String.format("Ingresso VIP - R$ %.2f", calcularPreco());
    }
}
