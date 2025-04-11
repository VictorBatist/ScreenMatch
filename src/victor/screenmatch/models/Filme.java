package victor.screenmatch.models;

public class Filme {
    public String nome;
    public int anoDeLancamento;
    boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    public int duracaoEmMinutos;

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public void exibeFichaTecnica(){
        System.out.println("nome do filme: " + nome);
        System.out.println("ano de lançamento: " + anoDeLancamento);
        System.out.println("duracao do filme em minutos " + duracaoEmMinutos );
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }
}
