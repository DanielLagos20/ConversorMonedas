package api;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient{
    String API_KEY = "pon_tu_api_key_aqui";
        public double obtenerConversion(String moneda, String monedaAConvertir, double cantidadAConvertir) throws IOException {
            String URL = "https://v6.exchangerate-api.com/v6/"+ API_KEY +"/latest/"+ moneda;
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                // Convertir JSON en objeto
                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
                JsonObject rates = json.getAsJsonObject("conversion_rates");

                // Extraer el valor de la moneda a convertir
                double valorMonedaAConvertir = rates.get(monedaAConvertir).getAsDouble();
                double valorConvertido = cantidadAConvertir *  valorMonedaAConvertir;
                return valorConvertido;

            } catch (IOException | InterruptedException | NullPointerException e) {
                System.err.println("Error al obtener la conversión: " + e.getMessage());
                return -1;
            }

        }


}
