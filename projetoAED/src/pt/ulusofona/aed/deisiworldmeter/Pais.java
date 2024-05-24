package pt.ulusofona.aed.deisiworldmeter;

public class Pais{
    int identificador;
    String alfaDois;
    String alfaTres;
    String nome;

    public Pais(int identificador, String alfaDois, String alfaTres, String nome) {
        this.identificador = identificador;
        this.alfaDois = alfaDois;
        this.alfaTres = alfaTres;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " | " + identificador + " | " + alfaDois.toUpperCase() + " | " + alfaTres.toUpperCase();
    }
}
