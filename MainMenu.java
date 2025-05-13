import java.util.Scanner;
// Utility class for generating unique IDs (simplified)
class IdGenerator {
    private static int userIdCounter = 0;
    private static int listIdCounter = 0;
    private static int cardIdCounter = 0;

    public static int generateUserId() {
        return ++userIdCounter;
    }

    public static int generateListId() {
        return ++listIdCounter;
    }

    public static int generateCardId() {
        return ++cardIdCounter;
    }
}
class MainMenu {
    private User currentUser;
    private Scanner scanner;

    public MainMenu(User currentUser, Scanner scanner) {
        this.currentUser = currentUser;
        this.scanner = scanner;
    }

    public String displayMainMenu() {
        System.out.println("\n===== Main Menu =====");
        System.out.println("Logged in as: " + currentUser.getUsername());
        System.out.println("1. Learn Mode");
        System.out.println("2. Vocabulary Management");
        System.out.println("3. Statistics");
        System.out.println("4. Grammar Learning");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    // handleUserSelection can be part of the main program loop
    // or you can expand this class to delegate to other modules
}
