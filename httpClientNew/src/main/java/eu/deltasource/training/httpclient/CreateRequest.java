package eu.deltasource.training.httpclient;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

/**
 * Created by Vasil Filipov - Delta Source Bulgaria on 10.12.18
 */
public class CreateRequest {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Create Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://deltasource.eu/"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("some string"))
                .build();

        // Create Client
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .authenticator(Authenticator.getDefault())
                .build();
    }
}
