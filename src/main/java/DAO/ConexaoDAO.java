
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    public Connection conexaoBD(){
        Connection conn = null;
        
        try{
           String url = "jdbc:mysql://localhost:3306/sistemahoteleiro?user=root&password=";
           conn = DriverManager.getConnection(url);
           
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ConexaoDao" + e.getMessage());
            
        }
        return conn;
    }
}

    
    

