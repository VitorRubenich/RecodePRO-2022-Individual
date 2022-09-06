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

    public Promocao getPromocao(int id){
        String sql = "SELECT from promocao WHERE id = ?";

        Promocao destPromo = new Promocao();

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rst = pstm.executeQuery();

            while(rst.next()){
                destPromo.setPercDesconto(rst.getInt("perc_desconto"));
                destPromo.setIdDestPromo(rst.getInt("id_destino"));
                destPromo.setValorComDesconto(rst.getInt("valor_com_desconto"));
                destPromo.setId(rst.getInt("id"));
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

    public List<Promocao> getPromooes() throws SQLException {
        String sql = "SELECT * from promocao";

        List<Promocao> promocoes = new ArrayList<>();

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){
                Promocao destPromo = new Promocao();
                destPromo.setPercDesconto(rst.getInt("perc_desconto"));
                destPromo.setIdDestPromo(rst.getInt("id_destino"));
                destPromo.setValorComDesconto(rst.getInt("valor_com_desconto"));
                destPromo.setId(rst.getInt("id"));

                promocoes.add(destPromo);
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
        return promocoes;
    }

    public void createPromocao(Destino destino){
        String sql = "INSERT INTO promocao(id_destino,perc_desconto,valor_com_desconto) VALUES (?,?,?)";

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, destino.getId());
            // Regra de negocio fazendo o calculo desconto
            pstm.setInt(2, 13);
            pstm.setDouble(3, 500);
            //pstm.setDouble(3, destino.getInformacoes());

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

    public void deletePromocaoById(int id){
        String sql = "DELETE from promocao WHERE id = ?";
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);
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
