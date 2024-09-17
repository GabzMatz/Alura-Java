package org.example;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Pesquisador {


    public String pesquisarCep(String cep) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    public void criarAquivoJson(String body) throws IOException, InterruptedException {

        Gson gson = new Gson();
        Descricacao info = gson.fromJson(body, Descricacao.class);

        usandoWritter(info);
    }
    private void usandoWritter(Descricacao nomeArquivo) throws IOException{

        FileWriter fw = new FileWriter("infos.json");
        fw.write(nomeArquivo.toString());


    }
}
