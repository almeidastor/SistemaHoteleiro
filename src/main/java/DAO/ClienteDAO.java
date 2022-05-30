
package DAO;
import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarCliente(ClienteDTO clientedao){
       String sql = "INSERT INTO `cadastro`(`id_cliente`, `dt_checkin`, `dt_checkout`, `responsavel`, `id_grupo`, `telefone`, `email`, `categoria`, `orientador`, `n_pessoas`, `n_quartos`, `pnormal`, `pvegetariano`, `pdiversos`, `pinternos`, `observacoes`, `valor`, `ckbvista`, `ckbtransferencia`, `ckbcheque`, `ckbcredito`, `ckb50`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       conn = new ConexaoDAO().conexaoBD();
       
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, clientedao.getId_Client());
             pstm.setString(2, clientedao.getId_Client());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"clienteDAO" + e);
        }
    }
        
    }

