package buscadordecep.main;
import buscadordecep.functions.GeradorDeArquivo;
import buscadordecep.models.ConsultaCep;
import buscadordecep.models.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String option = "";
        ConsultaCep consultaCep = new ConsultaCep();
        var gerador = new GeradorDeArquivo();
        List<Endereco>historicoConsultas = new ArrayList<>();

        while (option != "sair") {

            System.out.println(mensagemMenu());
            option = scan.nextLine();

            switch (option){
                case "1":
                    try {
                        Endereco novoEndereco = consultaCep.buscarEndereco("01001000");
                        gerador.salvarJson(novoEndereco);

                    } catch (RuntimeException | IOException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Finalizando a aplicação");
                    }
                    break;

                case "2":
                    option = "sair";break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static String mensagemMenu() {
        String mensagem ="""
                    *****************************************
                       -- Bem vindo ao consultor de CEP --   
                       
                       Digite como deseja progredir:
                       1 - Consultar um CEP
                       2 - Sair

                    """;
        return mensagem;
    }

    private static String mensagemConsulta(){
        String mensagem = "Digite o CEP que deseja consultar: ";
        return mensagem;
    }
}
