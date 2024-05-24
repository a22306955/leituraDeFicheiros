package pt.ulusofona.aed.deisiworldmeter;

public class Cidade {
    String alfaDois;
    String nomeCidade;
    int regiao;
    Double populacao;
    Double latitude;
    Double longitude;

    public Cidade(String alfaDois, String cidade, int regiao, Double populacao, Double latitude, Double longitude) {
        this.alfaDois = alfaDois;
        this.nomeCidade = cidade;
        this.regiao = regiao;
        this.populacao = populacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return nomeCidade.toUpperCase()+" | "+alfaDois.toUpperCase()+" | "+regiao+" | "+populacao+" | ("+latitude+","+longitude+")";
    }
}
