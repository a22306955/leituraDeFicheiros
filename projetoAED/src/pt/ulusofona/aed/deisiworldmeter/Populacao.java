package pt.ulusofona.aed.deisiworldmeter;

public class Populacao{
    int identificador;
    int ano;
    int populacaoMasculina;
    int populacaoFeminina;
    Double densidade;
    public Populacao(int identificador, int ano, int populacaoMasculina, int populacaoFeminina, Double densidade) {
        this.identificador = identificador;
        this.ano = ano;
        this.populacaoMasculina = populacaoMasculina;
        this.populacaoFeminina = populacaoFeminina;
        this.densidade = densidade;
    }

    @Override
    public String toString() {
        return "pt.ulusofona.aed.deisiworldmeter.Populacao{" +
                "identificador=" + identificador +
                ", ano=" + ano +
                ", populacaoMasculina=" + populacaoMasculina +
                ", populacaoFeminina=" + populacaoFeminina +
                ", densidade=" + densidade +
                '}';
    }
}
