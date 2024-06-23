package br.com.coinconverter.controller;

import br.com.coinconverter.model.MoedasExchangeAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaValoresMoedas {
    public MoedasExchangeAPI buscaTaxasConversaoExchangeAPI() throws IOException, InterruptedException {

        URI apiURL = URI.create("https://v6.exchangerate-api.com/v6/latest/USD");

        // Criando um cliente HTTP através de um construtor (builder)
        HttpClient client = HttpClient.newBuilder().build();

        // Criando uma requisição HTTP
        HttpRequest req = HttpRequest.newBuilder()
                .uri(apiURL)
                .header("Accept", "*/*")
                .header("Authorization", "Bearer b9a009c286977e23063c3201")
                .build();

        // Criando a response para capturar a resposta da requisição
        HttpResponse<String> response = client
                .send(req, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), MoedasExchangeAPI.class);
    }
}
