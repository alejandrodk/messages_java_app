import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection get_connection() {
        Connection db = null;
        try {
            db = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
        } catch(SQLException error) {
            System.out.println(error);
        }
        return db;
    }

}
