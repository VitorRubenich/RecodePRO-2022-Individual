package br.com.vitorrubenich.gotravel.dao;

import br.com.vitorrubenich.gotravel.factory.ConnectionFactory;
import br.com.vitorrubenich.gotravel.model.Contato;
import br.com.vitorrubenich.gotravel.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public Contato getContato(int id){
        String sql = "SELECT * from contatos WHERE id = ?";

        Contato contato = new Contato();

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rst = pstm.executeQuery();

            while(rst.next()){
                contato.setId(rst.getInt("id"));
                contato.setEmail(rst.getString("email"));
                contato.setFreqViagem(rst.getString("freq_viagens"));
                contato.setNome(rst.getString("nome"));
                contato.setLocaisInteresse(rst.getString("locais_interesse"));
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
        return contato;
    }

    public List<Contato> getContatos() throws SQLException {
        String sql = "SELECT * from contatos";

        List<Contato> contatos = new ArrayList<Contato>();

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){
                Contato contato = new Contato();
                contato.setId(rst.getInt("id"));
                contato.setEmail(rst.getString("email"));
                contato.setFreqViagem(rst.getString("freq_viagens"));
                contato.setNome(rst.getString("nome"));
                contato.setLocaisInteresse(rst.getString("locais_interesse"));
                contatos.add(contato);
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
        return contatos;
    }

    public void createContato(Usuario user){
        String sql = "INSERT INTO usuarios(nome,senha,dataCadastro) VALUES (?,?,?)";

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getSenha());
            var dt = new java.sql.Date(user.getDataCadastro().getTime());
            //transformando para data do sql ( /TODO refatorar
            pstm.setString(3, String.valueOf(dt));

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

    public void deleteContatoByYId(int id){
        String sql = "DELETE from contatos WHERE id = ?";
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
