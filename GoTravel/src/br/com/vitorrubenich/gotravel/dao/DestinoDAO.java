package br.com.vitorrubenich.gotravel.dao;

import br.com.vitorrubenich.gotravel.factory.ConnectionFactory;
import br.com.vitorrubenich.gotravel.model.Destino;
import br.com.vitorrubenich.gotravel.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinoDAO {
    Connection conn = null;
    PreparedStatement pstm = null;

    public Destino getDestino(int id){
        String sql = "SELECT * from destinos WHERE id = ?";

        Destino destino = new Destino();

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rst = pstm.executeQuery();

            while(rst.next()){
                destino.setAtracoes(rst.getString("atracoes"));
                destino.setEndereco(rst.getString("endereco"));
                destino.setInformacoes(rst.getString("informacoes"));
                destino.setId(rst.getInt("id"));
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
        return destino;
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
                dest.setEndereco(rst.getString("endereco"));
                dest.setId(rst.getInt("id"));
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

    public void createDestino(Destino destino){
        String sql = "INSERT INTO usuarios(atracoes,endereco,informacoes) VALUES (?,?,?)";

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, destino.getAtracoes());
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


    //multiplos updates
    public void alterarSenhaUsuario(Usuario user){
        String sql = "UPDATE usuarios SET senha = ? "+
                "WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, user.getSenha());

            pstm.setInt(2, user.getId());

            pstm.execute();
        }catch( Exception e){
            e.printStackTrace();
        }finally {
            try{
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

    }
}