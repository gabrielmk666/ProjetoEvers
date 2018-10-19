package ConexaoBD;

import Modelo.Modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;


public class daoEvers {
    
    Conexao con = new Conexao();
    Modelo mod = new Modelo();
    
    
       public void Salvar(Modelo med){
        con.conexao();
        
        try {
            PreparedStatement pst = con.con.prepareStatement("insert into produtos (nome,lote) values (?,?)");
            pst.setString(1,med.getNome());
            pst.setInt(2,med.getLote());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso!!","A V I S O",1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: \n"+ex);
        }
        
        con.desconecta();
    }
       public void Excluir(Modelo mod){
    
        con.conexao();
    
        try {
            PreparedStatement pst = con.con.prepareStatement("delete from produtos where lote= ?");
            pst.setInt(2,mod.getLote());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso","Parabéns",2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados","CAUTION",3);
        }
        
        con.desconecta();
    }

}
