package victor.screenmatch.view;

import victor.screenmatch.models.Filme;
import victor.screenmatch.models.Serie;
import victor.screenmatch.models.Titulo;

import java.util.ArrayList;

public class Listas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão",1970,180);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar - o poder das aguas",2024,260);
        outroFilme.avalia(7);
        var filmeDoJoao = new Filme("Waterworld - O segredo das aguas",1995,135);
        filmeDoJoao.avalia(10);

        Serie serie = new Serie("Lost",2010,2000);

        ArrayList<Titulo> listaAssistidos = new ArrayList<>();
        listaAssistidos.add(filmeDoJoao);
        listaAssistidos.add(meuFilme);
        listaAssistidos.add(outroFilme);

        listaAssistidos.add(serie);

        for(Titulo item : listaAssistidos){
            System.out.println(item.getNome());
            Filme filme = (Filme) item;
            System.out.println("Classificação: " + filme.getClassificacao() + " Estrelas" );
        }

    }
}
