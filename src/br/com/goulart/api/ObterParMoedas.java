package br.com.goulart.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.com.goulart.model.RespostaParesMoedas;
import br.com.goulart.Principal;

public class ObterParMoedas {
    public String moedaBase;
    public String moedaAlvo;
    public double quantidade;

    private String pegaURLCompleta(){
        return "https://v6.exchangerate-api.com/v6/4edb2e2e0365d5129ba71e34/pair/" +
                this.moedaBase + "/" + this.moedaAlvo + "/" + quantidade;
    }

    public RespostaParesMoedas obterParMoedas(){
        try{
            var urlRequisicao  = pegaURLCompleta();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requisicao  = HttpRequest.newBuilder()
                    .uri(URI.create(urlRequisicao))
                    .build();

            HttpResponse<String> resposta  = client
                    .send(requisicao, HttpResponse.BodyHandlers.ofString());

            String json = resposta.body();

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            return gson.fromJson(json, RespostaParesMoedas.class);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }
}