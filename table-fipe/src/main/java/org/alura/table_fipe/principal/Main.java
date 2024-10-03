package org.alura.table_fipe.principal;

import org.alura.table_fipe.model.Api;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private Api api = new Api();
    private Scanner sc = new Scanner(System.in);

    public void runner() throws IOException, InterruptedException {

        System.out.println("======================\nCarros\nMotos\nCaminhoes\nDigite uma das opções para consultar valores\n\n");
        api.runApi(api.createUrlMarcas(sc.nextLine()));

        System.out.println("======================\nDigite o codigo da marca\n\n");
        api.runApi(api.createUrlModelos());

        System.out.println("======================\nDigite o nome\n\n");
        api.runApi(api.createUrlAnos(sc.nextLine()));

        System.out.println("======================\nDigite o valor\n\n");
        api.runApi(api.createUrlValor(sc.nextLine()));

    }


}
