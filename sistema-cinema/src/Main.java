import logicaDoSistema.Filme;
import logicaDoSistema.Sessao;
import logicaDoSistema.SistemaIngressos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Filme> filmes(){
        List<Filme> filmes = new ArrayList<>();

        filmes.add(new Filme("A Hora do Mal", "Terror", 129, Arrays.asList(
                new Sessao("19:00", 6, 35),
                new Sessao("22:00", 5, 41)
        )));

        filmes.add(new Filme("Interestelar", "Ficção", 171, Arrays.asList(
                new Sessao("16:30", 1, 45),
                new Sessao("20:30", 1, 45)
        )));

        filmes.add(new Filme("Eu Faço Ela Voltar", "Terror", 90, Arrays.asList(
                new Sessao("19:20", 1, 25),
                new Sessao("21:30", 1, 45)
        )));

        filmes.add(new Filme("Superman", "Ação", 129, Arrays.asList(
                new Sessao("15:00", 1, 45),
                new Sessao("19:20", 1, 25),
                new Sessao("22:00", 1, 15)
        )));

        return filmes;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaIngressos cine = new SistemaIngressos(filmes());

        System.out.println("\n        BEM VINDO  AO CINEMA\n");
        System.out.println("___________________________________________________________\n");
        System.out.println("FILMES EM CARTAZ:\n");
        cine.listarFilmes();
        System.out.println("___________________________________________________________");

        cine.efetuarCompra(sc);

        sc.close();

    }
}
