import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyRequest {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/"+ "801e9f43a0b99336cd3d884d" +"/latest/";
    private String json;

    public CurrencyRequest(String fromCurrency)
            throws IOException {
        try {
            //http request, response
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + fromCurrency))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            this.json = response.body();

        } catch (Exception e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
    public String getJson() {
        return json;
    }
}
