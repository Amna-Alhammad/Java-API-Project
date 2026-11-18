import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiProject {

    public static void main(String[] args)
            throws IOException, InterruptedException {

        String url =
                "https://www.themealdb.com/api/json/v1/1/search.php?s=chicken";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                URI.create(url)
        ).build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() == 200) {
            System.out.println(response.body());
        } else {
            System.out.println("Request failed. Status code: "
                    + response.statusCode());
        }
    }
}