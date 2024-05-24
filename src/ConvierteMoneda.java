import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvierteMoneda {

    public Conversor convierteMoneda(String monedaBase, String monedaFinal, double monto){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5a911b468ff1f22995ad7ffb/pair/" + monedaBase + "/" + monedaFinal + "/" + monto);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Conversor.class);
        }catch(IOException | InterruptedException e){
            throw new RuntimeException("Valores invalidos");
        }

    }
}
