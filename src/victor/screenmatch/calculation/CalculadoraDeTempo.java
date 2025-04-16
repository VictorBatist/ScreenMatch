package victor.screenmatch.calculation;

import victor.screenmatch.models.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }
//
//    public void inclui (Filme f){
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//    public void inclui (Serie s){
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    public void inclui (Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
