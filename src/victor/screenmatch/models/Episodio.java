package victor.screenmatch.models;

import victor.screenmatch.calculation.Classificavel;

public class Episodio implements Classificavel {
    private int numeroDeEpisodios;
    private String nome;
    private Serie serie;
    private int totalDeVisualizacoes;

    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }

    public void setTotalDeVisualizacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }

    public int getNumeroDeEpisodios() {
        return numeroDeEpisodios;
    }

    public void setNumeroDeEpisodios(int numeroDeEpisodios) {
        this.numeroDeEpisodios = numeroDeEpisodios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {

        if(totalDeVisualizacoes >= 0){
            return 4;
        }else {
            return 0;
        }

    }
}
