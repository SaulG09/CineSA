package cinesa;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controlador {
    Connection con;
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String pass = "KekTro-0902";
    String URL = "jdbc:mysql://localhost:3306/cine";
    
    public Connection getConect(){
        con = null;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(URL, user, pass);
            if(con != null){
                System.out.println("Conexion exitosa");
                
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
