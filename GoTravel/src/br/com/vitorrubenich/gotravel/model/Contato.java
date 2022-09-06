package br.com.vitorrubenich.gotravel.model;

public class Contato {

    private String nome;
    private String email;
    private String locaisInteresse;
    private String freqViagem;
    private int id;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocaisInteresse() {
        return locaisInteresse;
    }

    public void setLocaisInteresse(String locaisInteresse) {
        this.locaisInteresse = locaisInteresse;
    }

    public String getFreqViagem() {
        return freqViagem;
    }

    public void setFreqViagem(String freqViagem) {
        this.freqViagem = freqViagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
