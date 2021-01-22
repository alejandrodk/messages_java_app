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

    public static void listMessages() {

    }

    public static void removeMessage() {

    }

    public static void updateMessage() {

    }
}
