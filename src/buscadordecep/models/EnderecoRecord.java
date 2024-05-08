package buscadordecep.models;

public record EnderecoRecord(String cep, String logradouro,
                             String complemento, String localidade, String uf) {
}
