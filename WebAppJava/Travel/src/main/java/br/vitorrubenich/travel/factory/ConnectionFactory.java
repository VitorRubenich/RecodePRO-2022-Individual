package br.vitorrubenich.travel.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
    private static final String PASSWORD = "vitor100";
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/gotravel";
    
    public static Connection createConnectionToMySQL() throws Exception, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL_DATABASE, USERNAME,PASSWORD);
        return connection;
    }
    public static void main(String[] args) throws Exception{
        Connection con = createConnectionToMySQL();
        if(con != null){
            System.out.println("Conexão obtida com suceso.");
            con.close();
        }
    }
}
