package ConexaoBD;

//import java.beans.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/ProjetoEvers";
    private String user = "postgres";
    private String key = "root";
    public Connection con;
    
    public void conexao(){
        
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(url, user, key);
            System.out.println("Conexão Efetuado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados:\n"+ex);
        }
    }
    
    public void executaSQL(String sql){
        try{
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao ExecutaSQL: \n"+ex.getMessage());
                }
        
    }
    
    public void desconecta(){
        
        try{
            con.close();
            System.out.println("Banco de Dados desconectado com sucesso!!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco de dados:\n"+ex);
        }
        
    }
    
}
