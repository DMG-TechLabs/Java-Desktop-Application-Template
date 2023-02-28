package api;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;

public class API {
        public API() throws IOException, InterruptedException, SQLException {
        }

        public String GET(String s) throws IOException, InterruptedException {
                HttpRequest request;
                HttpResponse<String> response;
                
                String apiUrl = null; //Url provided by selected api
                
                try {
                        request = HttpRequest.newBuilder()
                                .uri(URI.create(apiUrl))
                                .method("GET", HttpRequest.BodyPublishers.noBody())
                                .build();

                        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                } catch (ConnectException e) {
                        String error = "{\"message\":\"No Internet Connection\"}";
                        return error;
                }

                return response.body();
        }
}
