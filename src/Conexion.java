import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if(connect != null) {
                System.out.println("Connection successfully");
            }
        } catch(SQLException error) {
            System.out.println(error);
        }
        return connect;
    }

}
