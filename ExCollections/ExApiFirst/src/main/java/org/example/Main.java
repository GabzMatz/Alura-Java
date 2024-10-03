package org.example;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu cep:");
        String cep = sc.nextLine();

        Pesquisador pesquisador = new Pesquisador();

        String teste = pesquisador.pesquisarCep(cep);

        pesquisador.criarAquivoJson(teste);
    }
}