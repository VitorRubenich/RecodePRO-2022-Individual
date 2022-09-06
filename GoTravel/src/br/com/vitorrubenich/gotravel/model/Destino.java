package br.com.vitorrubenich.gotravel.model;

public class Destino {
    private String Endereco;
    private String Atracoes;
    private String Informacoes;
    private int id;

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getAtracoes() {
        return Atracoes;
    }

    public void setAtracoes(String atracoes) {
        Atracoes = atracoes;
    }

    public String getInformacoes() {
        return Informacoes;
    }

    public void setInformacoes(String informacoes) {
        Informacoes = informacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}