package logicaDoSistema;

import java.util.List;

public class Filme {

    private String titulo;
    private String genero;
    private int duracao;
    private List<Sessao> sessoes;

    public Filme(String titulo, String genero, int duracao, List<Sessao> sessoes) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.sessoes = sessoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    @Override
    public String toString() {
        return titulo + " - " + genero + " - " + duracao + " minutos"+ "\nSessões Disponíveis:\n" + sessoes + "\n";

    }
}
