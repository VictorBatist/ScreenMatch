package victor.screenmatch.models;

public class Serie extends Titulo{
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    public Serie (String nome, int anoDeLancamento, int duracaoEmMinutos){
        super(nome, anoDeLancamento, duracaoEmMinutos);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos(){
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    @Override
    public void exibeFichaTecnica(){
        System.out.println("nome do filme: " + super.getNome());
        System.out.println("ano de lançamento: " + super.getAnoDeLancamento());
        System.out.println("duracao do filme em minutos " + getDuracaoEmMinutos());
    }

    @Override
    public String toString() {
        return """
               Serie: %s
               Ano de lançamento: %d
               
               """.formatted(this.getNome(), this.getAnoDeLancamento());
    }
}
