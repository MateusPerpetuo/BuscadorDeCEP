package buscadordecep.main;
import buscadordecep.functions.GeradorDeArquivo;
import buscadordecep.models.ConsultaCep;
import buscadordecep.models.Endereco;
import buscadordecep.models.EnderecoRecord;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String option = "";
        ConsultaCep consultaCep = new ConsultaCep();
        List<Endereco>historicoConsultas = new ArrayList<>();

        while (option != "sair") {

            System.out.println(mensagemMenu());
            option = scan.nextLine();

            switch (option){
                case "1":
                    try {
                        System.out.println(mensagemConsulta());
                        String cepConsulta = scan.nextLine();

                        EnderecoRecord novoEnderecoRecord = consultaCep.buscarEndereco(cepConsulta);

                        Endereco endereco = new Endereco(novoEnderecoRecord);
                        System.out.println(endereco.toString());

                        historicoConsultas.add(endereco);

                    } catch (RuntimeException  e) {
                        System.out.println(e.getMessage());
                        System.out.println("Finalizando a aplicação");
                    }
                    break;
                case "2":
                    System.out.println(mensagemSaida());
                    option = "sair";
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        try {
            var gerador = new GeradorDeArquivo();
            gerador.salvarJson(historicoConsultas);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    private static String mensagemSaida() {
        String mensagem ="""
                    
                       --      Pesquisa concluida!     --   
                       
                      Não se esqueça de conferir o arquivo
                      que foi gerado, com todas os resultados 
                      de suas pesquisas.
                      
                    *****************************************
                    """;
        return mensagem;
    }

}
