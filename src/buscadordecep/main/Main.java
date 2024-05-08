package buscadordecep.main;
import buscadordecep.models.ConsultaCep;
import buscadordecep.models.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        ConsultaCep consultaCep = new ConsultaCep();


        Endereco novoEndereco = consultaCep.buscarEndereco("01001000");
        System.out.println(novoEndereco);
    }

}
