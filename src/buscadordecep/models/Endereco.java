package buscadordecep.models;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String localidade;
    private String uf;


    public Endereco(EnderecoRecord enderecoRecord) {
        this.cep = enderecoRecord.cep();
        this.logradouro = enderecoRecord.logradouro();
        this.complemento = enderecoRecord.complemento();
        this.localidade = enderecoRecord.localidade();
        this.uf = enderecoRecord.uf();
    }

    @Override
    public String toString() {
        return "\nInformações do CEP: " + this.cep
                +"\nLogradouro: " + logradouro
                + "\nComplemento: " + complemento
                + "\nLocalidade: " + localidade
                + "\nUF: " + uf + "\n";
    }

    public String getCep() {
        return cep;
    }
}

