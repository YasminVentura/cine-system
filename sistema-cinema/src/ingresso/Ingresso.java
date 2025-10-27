package ingresso;

public abstract class Ingresso {
    protected double precoBase;

    public Ingresso(double precoBase) {
        this.precoBase = precoBase;
    }

    public abstract double calcularPreco();
}