package br.com.vitorrubenich.gotravel.dao;

import br.com.vitorrubenich.gotravel.factory.ConnectionFactory;
import br.com.vitorrubenich.gotravel.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO {
    Connection conn = null;
    PreparedStatement pstm = null;

    public Usuario getUsuario(int id){
        String sql = "SELECT * from usuarios WHERE id = ?";

        Usuario user = new Usuario();

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rst = pstm.executeQuery();

            while(rst.next()){
                user.setId(rst.getInt("id"));
                user.setNome(rst.getString("nome"));
                user.setDataCadastro((rst.getDate("dataCadastro")));
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
        return user;
    }

    public List<Usuario> getUsuarios() throws SQLException {
        String sql = "SELECT * from usuarios";

        List<Usuario> contatos = new ArrayList<Usuario>();



        ResultSet rst = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){
                Usuario ct = new Usuario();
                ct.setId(rst.getInt("id"));
                ct.setNome(rst.getString("nome"));
                ct.setDataCadastro((rst.getDate("dataCadastro")));
                contatos.add(ct);
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

    public void createUsuario(Usuario user){
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

    public void deleteUsuarioById(int id){
        String sql = "DELETE from usuarios WHERE id = ?";
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