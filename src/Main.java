import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        try(Connection cnx = conexion.get_connection()) {

        } catch(Exception error) {
            System.out.println(error);
        }
    }
}
