package org.alura.table_fipe.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Api  {

    private String urlDefault = "https://parallelum.com.br/fipe/api/v1/";
    private String option;
    private String modelo;
    private String anos;
    private Gson gson = new Gson();
    private Scanner sc = new Scanner(System.in);

    public String createUrlMarcas(String option){
        urlDefault = urlDefault + option;
        this.urlDefault = urlDefault+"/marcas/";
        this.option = option;
        return urlDefault;
    }
    public String createUrlModelos(){
        this.urlDefault = urlDefault+"/marcas/";
        return urlDefault;
    }

    public String createUrlAnos(String anos){
        urlDefault = urlDefault + anos;
        this.urlDefault = urlDefault+"/anos/";
        this.anos = anos;
        return urlDefault;
    }
    public String createUrlValor(String valor){
        urlDefault = urlDefault + valor;
        return urlDefault;
    }



    public List<Modelo> runApi(String urlPattern) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlPattern))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


        if (urlPattern.contains("marcas")){
            Type itemListType = new TypeToken<List<Modelo>>() {}.getType();
            List<Modelo> carros = gson.fromJson(response.body(), itemListType); //

            carros.forEach(d -> {
                System.out.println("Codigo: "+d.cod()+ " Descricao: "+d.descricao());
            });

            return carros;
        }


        return null;
    }
}
