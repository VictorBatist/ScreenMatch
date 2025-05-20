package victor.screenmatch.view;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import victor.screenmatch.exception.ErroDeConversaoDeAnoException;
import victor.screenmatch.models.Titulo;
import victor.screenmatch.models.TituloOmdb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.IllegalFormatException;
import java.util.Scanner;


public class Buscas {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:/Users/jvict/Desktop/screenmatch/src/api/properties/ApiKey.txt");

        Scanner scannerKey = new Scanner(file);
        String line = scannerKey.nextLine();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        var busca = scanner.nextLine();

        String address = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + line;
        System.out.println(address);

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);

            //try{
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Um titulo já convertido:");
            System.out.println(meuTitulo);

            FileWriter escreverArquivo = new FileWriter("filmes.txt");
            escreverArquivo.write(meuTitulo.toString());
            escreverArquivo.close();

        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Aconteceu algum erro de argumento na busca, verifique o endereço");
        }catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }

        System.out.println("O programa finalizou corretamente!");
    }
}
