package com.aluracurses.convertidorMonedas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Busqueda {
    public double valor;
    public void setValor(String mon1, String mon2) throws IOException, InterruptedException {
        HttpClient client =HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/29e62006cd8e9c4ef46a090f/latest/"+mon1))
                .build();
        HttpResponse<String> response =client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());
        String json =response.body();
        //System.out.println(response.body());
        Gson gson =new Gson();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // Extraer el objeto conversion_rates
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Obtener el valor de AED

        if (conversionRates != null && conversionRates.has(mon2)) {
            double proporcion = conversionRates.get(mon2).getAsDouble();
            System.out.println("El tipo de cambio para " +mon2+ " es:" + proporcion);
            this.valor = proporcion ;
        } else {
            System.out.println("No se encontró el valor de "+ mon2 +" en conversion_rates.");
        }

    }
    public double getValor() {
        return this.valor;
    }

}
