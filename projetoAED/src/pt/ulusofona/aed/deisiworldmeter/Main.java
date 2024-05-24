package pt.ulusofona.aed.deisiworldmeter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    static ArrayList<Pais> paises = new ArrayList();
    static ArrayList<Cidade> cidades = new ArrayList();
    static ArrayList<Populacao> populacoes = new ArrayList();
    static ArrayList<InputInvalido> invalido = new ArrayList();


    static void reset() {
        paises = new ArrayList();
        cidades = new ArrayList();
        populacoes = new ArrayList();
        invalido = new ArrayList();
    }

    static boolean parseFiles(File dir) {
        reset();

        if (parsePaises(new File("paises.csv"))) {
            System.out.println("1");
        }
        if (parseCidades(new File("cidades.csv"))) {
            System.out.println("2");
        }
        if(parsePopulacao(new File("populacao.csv"))){
            System.out.println("3");
            return true;
        } else {
            System.out.println("nao encontrado");
            return false;
        }
    }


    private static boolean parsePaises(File ficheiro) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(ficheiro);
        } catch (FileNotFoundException e) {
            return false;
        }

        boolean primeiraLinha = true;
        int linhasCorretas = 0;
        int numLinhasFalsas=0;
        int primeiraLinhaFalsa=-1;

        while (scanner.hasNext()) {
            String linha = scanner.nextLine();

            if (primeiraLinha) {
                primeiraLinha = false;
            } else {
                String[] partes = linha.split(",");
                if (partes.length == 4 && !partes[0].isEmpty() && !partes[1].isEmpty() && !partes[2].isEmpty() && !partes[3].isEmpty()) {
                    int identificador = Integer.parseInt(partes[0]);
                    String alfaDois = partes[1];
                    String alfaTres = partes[2];
                    String nomePais = partes[3];
                    Pais pais = new Pais(identificador, alfaDois, alfaTres, nomePais);
                    paises.add(pais);
                    linhasCorretas++;
                } else if(primeiraLinhaFalsa==-1){
                    primeiraLinhaFalsa= linhasCorretas +1;
                    numLinhasFalsas++;
                } else {
                    numLinhasFalsas++;
                }

            }
        }
        InputInvalido casoInvalido= new InputInvalido("paises.csv",linhasCorretas,numLinhasFalsas,primeiraLinhaFalsa);
        invalido.add(casoInvalido);
        return true; //correu bem
    }


    private static boolean parseCidades(File file) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return false;
        }

        int linhasCorretas = 0;
        int numLinhasFalsas=0;
        int primeiraLinhaFalsa=-1;
        boolean primeiraLinha = true;

        while (scanner.hasNext()){
            String linha = scanner.nextLine();

            if(primeiraLinha){
                primeiraLinha = false;
            } else {
                String[] partes = linha.split(",");

                if(partes.length==6 && !partes[0].isEmpty() && !partes[1].isEmpty() && !partes[2].isEmpty() && !partes[4].isEmpty() && !partes[5].isEmpty()) {
                    String alfaDois = partes[0];
                    String nomeCidade = partes[1];
                    int regiao = Integer.parseInt(partes[2]);
                    Double populacao;
                    if (partes[3] == "") {
                        populacao = 0.0;
                    } else {
                        populacao = Double.parseDouble(partes[3]);
                    }
                    Double latitude = Double.parseDouble(partes[4]);
                    Double longitude = Double.parseDouble(partes[5]);
                    Cidade cidade = new Cidade(alfaDois, nomeCidade, regiao, populacao, latitude, longitude);
                    cidades.add(cidade);
                    linhasCorretas++;
                } else if(primeiraLinhaFalsa==-1){
                    primeiraLinhaFalsa= linhasCorretas +1;
                    numLinhasFalsas++;
                } else{
                    numLinhasFalsas++;
                }

            }
        }
        InputInvalido casoInvalido= new InputInvalido("cidades.csv",linhasCorretas,numLinhasFalsas,primeiraLinhaFalsa);
        invalido.add(casoInvalido);
        return true; // se correr bem
    }

    private static boolean parsePopulacao(File file) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return false;
        }

        int linhasCorretas = 0;
        int numLinhasFalsas=0;
        int primeiraLinhaFalsa=-1;
        boolean primeiraLinha = true;

        while (scanner.hasNext()){
            String linha = scanner.nextLine();
            if(primeiraLinha){
                primeiraLinha = false;
            } else {
                String[] partes = linha.split(",");

                if(partes.length==5&& !partes[0].isEmpty() && !partes[1].isEmpty() && !partes[2].isEmpty() && !partes[3].isEmpty() && !partes[4].isEmpty()){
                    int identificador = Integer.parseInt(partes[0]);
                    int ano = Integer.parseInt(partes[1]);
                    int populacaoMasculina = Integer.parseInt(partes[2]);
                    int populacaoFeminina = Integer.parseInt(partes[3]);
                    Double densidade= Double.parseDouble(partes[4]);
                    Populacao populacao = new Populacao(identificador, ano, populacaoMasculina, populacaoFeminina,densidade);
                    populacoes.add(populacao);
                    linhasCorretas++;
                } else if(primeiraLinhaFalsa==0){
                    primeiraLinhaFalsa= linhasCorretas +1;
                    numLinhasFalsas++;
                } else{
                    numLinhasFalsas++;
                }
            }
        }
        InputInvalido casoInvalido= new InputInvalido("populacao.csv",linhasCorretas,numLinhasFalsas,primeiraLinhaFalsa);
        invalido.add(casoInvalido);
        return true; // se correr bem
    }

    static ArrayList getObjects(TipoEntidade tipoDeFicheiro){
       if(tipoDeFicheiro==TipoEntidade.PAIS){
           return paises;
       }else if(tipoDeFicheiro==TipoEntidade.CIDADE){
           return cidades;
       } else if(tipoDeFicheiro==TipoEntidade.INPUT_INVALIDO){
           return invalido;
       }
       return null;
    }


    public static void main(String[] args) {

       boolean parseOK = parseFiles(new File("cidades.csv"));
        if(!parseOK){
            System.out.println("não correu bem");
            return;
        } else {
            System.out.println("correu bem");

        }
       /* ArrayList invalidos= getObjects(TipoEntidade.INPUT_INVALIDO);
        System.out.println(invalidos.get(0));
        ArrayList paises = getObjects(TipoEntidade.PAIS);
        System.out.println(paises.get(57));
        ArrayList cidades = getObjects(TipoEntidade.CIDADE);

        System.out.println(cidades.get(0));*/

    }
}
