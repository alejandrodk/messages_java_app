import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("------------------------");
            System.out.println("Messages App");
            System.out.println("1. Create message");
            System.out.println("2. List messages");
            System.out.println("3. Update message");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");
            System.out.println("------------------------");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    List<Message> messages = MessageService.listMessages();
                    for (Message item : messages) {
                        System.out.println(item.toString());
                    }
                    System.out.println("Messages listed successfully");
                    break;
                case 3:
                    MessageService.updateMessage();
                    break;
                case 4:
                    MessageService.removeMessage();
                    break;
                default:
                    break;
            }
        } while (option != 5);
        System.out.println("App closed successfully");
    }
}
