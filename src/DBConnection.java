import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection dbConnection;
    public static Connection get_connection() {
       if(dbConnection == null) {
           try {
               dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
           } catch(SQLException error) {
               System.out.println(error);
           }
       }
        return dbConnection;
    }

}
