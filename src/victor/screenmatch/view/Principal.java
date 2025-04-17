package victor.screenmatch.view;

import victor.screenmatch.calculation.CalculadoraDeTempo;
import victor.screenmatch.calculation.FiltroRecomendacao;
import victor.screenmatch.models.Episodio;
import victor.screenmatch.models.Filme;
import victor.screenmatch.models.Serie;

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
    }
}
