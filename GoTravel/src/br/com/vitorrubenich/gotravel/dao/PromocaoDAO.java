package br.com.vitorrubenich.gotravel.dao;

import br.com.vitorrubenich.gotravel.factory.ConnectionFactory;
import br.com.vitorrubenich.gotravel.model.Destino;
import br.com.vitorrubenich.gotravel.model.Promocao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public Destino getPromocao(int id){
        String sql = "SELECT * from promocao WHERE id = ?";

        Promocao destPromo = new Promocao();

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rst = pstm.executeQuery();

            while(rst.next()){
                // criar promo
                //destPromo.setDestPromo(rst.getString("atracoes"));
                destPromo.setEndereco(rst.getString("endereco"));
                destPromo.setInformacoes(rst.getString("informacoes"));
            }
        }catch( Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rst != null){
                    rst.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return destPromo;
    }

    public List<Destino> getDestinos() throws SQLException {
        String sql = "SELECT * from destinos";

        List<Destino> destinos = new ArrayList<Destino>();



        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){
                Destino dest = new Destino();
                dest.setInformacoes(rst.getString("informacoes"));
                dest.setAtracoes(rst.getString("atracoes"));
                dest.setEndereco((rst.getString("endereco")));
                destinos.add(dest);
            }
        }catch( Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rst != null){
                    rst.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return destinos;
    }

    public void createPromocao(Destino destino){
        String sql = "INSERT INTO promocao(destino,endereco,informacoes) VALUES (?,?,?)";

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, destino.getAtracoes());
            pstm.setString(2, destino.getEndereco());
            pstm.setString(3, destino.getInformacoes());

            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
