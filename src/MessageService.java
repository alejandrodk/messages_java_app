import java.util.List;
import java.util.Scanner;

public class MessageService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type your message here");
        String message = sc.nextLine();

        System.out.println("Who are you?");
        String author = sc.nextLine();

        Message msg = new Message();
        msg.setMessage(message);
        msg.setAuthor(author);

        MessageDAO.createMessage(msg);
    }

    public static List<Message> listMessages() {
        return MessageDAO.readMessages();
    }

    public static void updateMessage() {
        System.out.println("Update a message");

        Scanner sc = new Scanner(System.in);

        System.out.println("Type message id");
        String id = sc.nextLine();

        System.out.println("Type new message value");
        String message = sc.nextLine();

        MessageDAO.updateMessage(id, message);
        System.out.println("Message updated successfully");
    }

    public static void removeMessage() {

    }
}
