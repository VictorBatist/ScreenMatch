package victor.screenmatch.view;

import com.google.gson.Gson;
import victor.screenmatch.models.Titulo;
import victor.screenmatch.models.TituloOmdb;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Buscas {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:/Users/jvict/Desktop/screenmatch/src/api/properties/ApiKey.txt");

        Scanner scannerKey = new Scanner(file);
        String line = scannerKey.nextLine();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        var busca = scanner.nextLine();

        String address = "http://www.omdbapi.com/?t=" + busca + line;


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);


    }
}
