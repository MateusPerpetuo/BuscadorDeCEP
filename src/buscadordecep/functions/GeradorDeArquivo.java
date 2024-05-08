package buscadordecep.functions;
import buscadordecep.models.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeradorDeArquivo {
    public void salvarJson (List<Endereco> historico) throws IOException {
        LocalDateTime dataPesquisa = LocalDateTime.now();
        DateTimeFormatter dataFortadadatacao = DateTimeFormatter.ofPattern("dd/MM");
        String data = dataPesquisa.format(dataFortadadatacao).replace("/","-");

        FileWriter escritor = new FileWriter("CepsPesquizados-"
                                        + data +".txt");

     //   FileWriter escritor = new FileWriter("CepsPesquizados.json");

        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        escritor.write(gson.toJson(historico));
        escritor.close();
    }
}
