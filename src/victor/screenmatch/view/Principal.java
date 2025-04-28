package victor.screenmatch.view;

import victor.screenmatch.calculation.CalculadoraDeTempo;
import victor.screenmatch.calculation.FiltroRecomendacao;
import victor.screenmatch.models.Episodio;
import victor.screenmatch.models.Filme;
import victor.screenmatch.models.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(5);
        meuFilme.avalia(8);
        meuFilme.avalia(10);

        //System.out.println(meuFilme.somaDasAvaliacoes);
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie serie = new Serie();
        serie.setNome("Lost");
        serie.setAnoDeLancamento(2010);

        serie.setTemporadas(4);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(50);
        System.out.println("Tempo para maratonar a serie : " + serie.getDuracaoEmMinutos());

        serie.exibeFichaTecnica();

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar o poder das aguas");
        outroFilme.setAnoDeLancamento(2024);
        outroFilme.setDuracaoEmMinutos(260);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(serie);
        System.out.println("Tempo total assistido: " + calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumeroDeEpisodios(1);
        episodio.setSerie(serie);
        episodio.setTotalDeVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoJoao = new Filme();
        filmeDoJoao.setNome("Waterworld - O segredo das aguas");
        filmeDoJoao.setAnoDeLancamento(1995);
        filmeDoJoao.setDuracaoEmMinutos(135);
        filmeDoJoao.avalia(10);

        ArrayList <Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoJoao);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("O primeiro filme é " + listaDeFilmes.get(0).getNome());

        System.out.println("lista de filmes: " + listaDeFilmes);
        System.out.println("toString: " + listaDeFilmes.get(0).toString());
    }
}
