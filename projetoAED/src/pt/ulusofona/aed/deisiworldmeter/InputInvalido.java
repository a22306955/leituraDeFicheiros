package pt.ulusofona.aed.deisiworldmeter;

public class InputInvalido {
    String nomeFicheiro;
    int numeroLinhasCertas;
    int numeroLinhasIncorretas;
    int primeiraLinhaIncorreta;

    public InputInvalido(String nomeFicheiro, int numeroLinhasCertas, int nmeroLinhasIncorretas, int primeiraLinhaIncorreta) {
        this.nomeFicheiro = nomeFicheiro;
        this.numeroLinhasCertas = numeroLinhasCertas;
        this.numeroLinhasIncorretas = nmeroLinhasIncorretas;
        this.primeiraLinhaIncorreta = primeiraLinhaIncorreta;
    }
    public String toString(){
        return nomeFicheiro+" | "+numeroLinhasCertas+" | "+numeroLinhasIncorretas+" | "+primeiraLinhaIncorreta;
    }
}
