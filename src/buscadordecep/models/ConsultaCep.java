package buscadordecep.models;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public EnderecoRecord buscarEndereco(String cep){
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
            return new Gson().fromJson(response.body(), EnderecoRecord.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço aparti desse CEP.");
        }
    }

    public boolean validarCep(String cep){
        boolean formatoValido = cep.matches("^[0-9]{8}$");
        if (formatoValido){
            return true;
        } else {
            return false;
        }
    }
}
