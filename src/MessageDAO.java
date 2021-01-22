import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    public static void createMessage(Message message) {
        DBConnection connection = new DBConnection();
        try (Connection conn = connection.get_connection()){
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

    public static List<Message> readMessages() {
        DBConnection connection = new DBConnection();
        try (Connection conn = connection.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;

            List<Message> result = new ArrayList<>();
            try {
                String query = "SELECT * FROM mensajes";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();

                while(rs.next()) {
                    int id = rs.getInt("id");
                    String message = rs.getString("message");
                    String author = rs.getString("author");
                    result.add(new Message(id, message, author));
                }
                return result;
            } catch(SQLException exception) {
                System.out.println(exception);
            }
        } catch(SQLException error){
            System.out.println(error);
        }
        return null;
    }

    public static void updateMessage(String id, String message) {
        DBConnection connection = new DBConnection();
        try (Connection conn = connection.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                String query = "UPDATE mensajes SET message = ? WHERE id = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, message);
                ps.setString(2, id);
                ps.executeUpdate();
            } catch(SQLException exception) {
                System.out.println(exception);
            }
        } catch(SQLException error){
            System.out.println(error);
        }
    }

    public static void removeMessage(String id) {
        DBConnection connection = new DBConnection();
        try (Connection conn = connection.get_connection()){
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE id = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, id);
                ps.executeUpdate();
            } catch(SQLException exception) {
                System.out.println(exception);
            }
        } catch(SQLException error){
            System.out.println(error);
        }
    }
}
