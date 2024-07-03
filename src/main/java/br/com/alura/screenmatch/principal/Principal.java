package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.cglib.core.Converter;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();

    private ConverteDados conversor = new ConverteDados();


    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    public void exibeMenu(){

        System.out.println("Digite o nome da série para");
        var nomeSerie = leitura.nextLine();

        var json = consumo.obterDados( ENDERECO + nomeSerie.replace(" ", "+" ) + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        // "https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c"
    }


}
