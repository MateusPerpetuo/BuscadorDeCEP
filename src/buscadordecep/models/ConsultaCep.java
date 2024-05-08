package buscadordecep.models;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public Endereco buscarEndereco(String cep){

        URI enrereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        // Aqui estamos pedindo uma informação para a API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(enrereco)
                .build();

        // Resposta da API
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço aparti desse CEP.");
        }

    }
}
