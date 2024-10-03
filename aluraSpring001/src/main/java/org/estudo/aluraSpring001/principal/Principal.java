package org.estudo.aluraSpring001.principal;

import org.estudo.aluraSpring001.model.DadosEpisodio;
import org.estudo.aluraSpring001.model.DadosSeries;
import org.estudo.aluraSpring001.model.DadosTemporada;
import org.estudo.aluraSpring001.model.Episodio;
import org.estudo.aluraSpring001.service.ConsumoApi;
import org.estudo.aluraSpring001.service.ConverterDados;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Principal {

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String APIKEY="&apikey=a500606f";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();
    private DecimalFormat df = new DecimalFormat("#.00");

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("Digite o nome da serie: ");
        var nomeSerie = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSeries dados = conversor.obterDados(json, DadosSeries.class);


        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + APIKEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
//		temporadas.stream().forEach(System.out::println);

//        for(int i = 0; i < dados.totalTemporadas(); i++){
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j=0; j < episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//
//        }

//        temporadas.forEach(t -> t.episodios().forEach
//                (e -> System.out.println(e.titulo())));
//
//        List<DadosEpisodio> dadosEpisodios = temporadas.stream().flatMap(t -> t.episodios().stream()).collect(Collectors.toList());//Assim daria pra modificar a lista
//        //List<DadosEpisodio> dadosEpisodios = temporadas.stream().flatMap(t -> t.episodios().stream()).toList(); //Nao da pra modificar
//
//
//        dadosEpisodios.stream()
//                .filter(e-> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//                .limit(5)
//                .forEach(System.out::println);

//
//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()
//                        .map(d -> new Episodio(t.numero(), d)))
//                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
//                .limit(5)
//                .toList();

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .toList();


        episodios.forEach(System.out::println);


        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0).collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        System.out.println("Media: "+df.format(est.getAverage()));
        System.out.println("Melhor: "+df.format(est.getMax()));
        System.out.println("Pior: "+df.format(est.getMin()));

//        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
//                .filter(e -> e.getAvaliacao() > 0.0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada,
//                        Collectors.averagingDouble(Episodio::getAvaliacao)));
//        avaliacoesPorTemporada.forEach((temporada, media)->System.out.println("Temporada " + temporada + ": " + df.format(media)));
//
//
//
//        System.out.println("Digite um episodio da serie pra fazer a pesquisa");
//        String nameForSearch = sc.nextLine();
//
//        Optional<Episodio> search = episodios.stream()
//                .filter(t -> t.getTitulo().toUpperCase().contains(nameForSearch.toUpperCase()))
//                .findFirst();
//
//        if (search.isPresent()) {
//            System.out.println(search.get().getTitulo()+"\nTemporada: "+ search.get().getTemporada() );
//        } else {
//            System.out.println("Nao encontrado");
//        }


//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()
//                        .map(d -> new Episodio(t.numero(),d)))
//                .collect(Collectors.toList());


//        System.out.println("Que ano voce deseja ver os episodios?");
//        var ano = sc.nextInt();
//        sc.nextLine();
//
//
//        LocalDate dataBusca = LocalDate.of(ano,1,1);
//
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream().filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e-> System.out.println("Temporada = "+ e.getTemporada() +
//                        "Episodio =" + e.getTitulo() +
//                        "Data lancamento = " + e.getDataLancamento().format(df)));

    }
    }