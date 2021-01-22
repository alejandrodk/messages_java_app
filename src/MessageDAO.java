import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {

    public static void createMessage(Message message) {
        try (Connection conn = DBConnection.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (message, author) VALUES (?,?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAuthor());
                ps.executeUpdate();
                System.out.println("Message created successfully");
            } catch(SQLException exception) {
                System.out.println(exception);
            }
        } catch(SQLException error){
            System.out.println(error);
        }
    }

    public static void readMessages() {

    }

    public static void removeMessage(int id) {

    }

    public static void updateMessage(Message message) {

    }
}
