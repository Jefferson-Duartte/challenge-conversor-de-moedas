package com.jefferson.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class ApiService {

    public static Map<String, Double> getCurrencyRates() throws IOException {
        URL url = new URL("https://v6.exchangerate-api.com/v6/bb838de9274d5f25fde4648e/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObj = root.getAsJsonObject().get("conversion_rates").getAsJsonObject();
        Map<String, Double> currencyRates = new HashMap<>();
        currencyRates.put("USD", jsonObj.get("USD").getAsDouble());
        currencyRates.put("BRL", jsonObj.get("BRL").getAsDouble());
        currencyRates.put("ARS", jsonObj.get("ARS").getAsDouble());
        currencyRates.put("COP", jsonObj.get("COP").getAsDouble());

        return currencyRates;
    }

}

