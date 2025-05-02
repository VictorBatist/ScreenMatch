package victor.screenmatch.models;

import victor.screenmatch.calculation.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome,int anoLancamento, int duracaoEmMinutos){
       super(nome, anoLancamento, duracaoEmMinutos);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        //"Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")" ;
        return """
               Filme: %s
               Ano de Lançamento: %d
               """.formatted(this.getNome(),this.getAnoDeLancamento());
    }
}
