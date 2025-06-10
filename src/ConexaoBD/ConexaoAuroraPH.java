
package ConexaoBD;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
public class ConexaoAuroraPH {
    public Connection getConnection() {
        //Edite essa parte para conectar com o banco de dados da máquina
        try {return DriverManager.getConnection("jdbc:mysql://localhost/Aurorapalace","root","");
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
