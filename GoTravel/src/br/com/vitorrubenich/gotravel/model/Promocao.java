package br.com.vitorrubenich.gotravel.model;

public class Promocao {
    private int percDesconto;
    private double valorComDesconto;
    private int idDestPromo;

    private int id;



    public int getPercDesconto() {
        return percDesconto;
    }

    public void setPercDesconto(int percDesconto) {
        this.percDesconto = percDesconto;
    }

    public double getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(double valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }

    public int getIdDestPromo() {
        return idDestPromo;
    }

    public void setIdDestPromo(int idDestPromo) {
        this.idDestPromo = idDestPromo;
    }
}
