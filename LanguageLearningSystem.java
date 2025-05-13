import java.util.ArrayList;
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
public class LanguageLearningSystem {
    private static ArrayList<User> users = new ArrayList<>(); // In-memory user store
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    // Mock authentication: find user by username
    private static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
    
    private static User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to the Language Learning System!");

        // Initial dummy user for testing
        // users.add(new User("testuser", "password123", "test@example.com"));


        // Authentication
        while (currentUser == null) {
            System.out.println("\n1. Login");
            System.out.println("2. Signup");
            System.out.print("Choose an option: ");
            String authChoice = scanner.nextLine();

            if (authChoice.equals("1")) { // Login
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                currentUser = authenticateUser(username, password);
                if (currentUser != null) {
                    System.out.println("Login successful! Welcome back, " + currentUser.getUsername());
                    // currentUser.loadUserData(); // Placeholder
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if (authChoice.equals("2")) { // Signup
                System.out.print("Enter new username: ");
                String newUsername = scanner.nextLine();
                
                if(findUserByUsername(newUsername) != null){
                    System.out.println("Username already exists. Please choose another one.");
                    continue;
                }
                
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                System.out.print("Enter email: ");
                String newEmail = scanner.nextLine();
                
                User newUser = new User(newUsername, newPassword, newEmail);
                users.add(newUser);
                currentUser = newUser; // Automatically log in new user
                System.out.println("Signup successful! Welcome, " + currentUser.getUsername());
                // currentUser.saveUserData(); // Placeholder for initial save
            } else {
                System.out.println("Invalid choice.");
            }
        }

        // Main program loop
        MainMenu mainMenu = new MainMenu(currentUser, scanner);
        boolean running = true;
        while (running) {
            String userChoice = mainMenu.displayMainMenu();

            switch (userChoice) {
                case "1": // Learn Mode
                    LearnMode learnMode = new LearnMode(currentUser, scanner);
                    learnMode.selectAndStart();
                    break;
                case "2": // Vocabulary Management
                    VocabularyManagementMode vocabManager = new VocabularyManagementMode(currentUser, scanner);
                    vocabManager.displayOptions();
                    break;
                case "3": // Statistics
                    StatisticsTracker statsTracker = new StatisticsTracker(currentUser);
                    statsTracker.generateDetailedReport();
                    break;
                case "4": // Grammar Learning
                    GrammarLearningModule grammarModule = new GrammarLearningModule(currentUser, scanner);
                    grammarModule.start();
                    break;
                case "5": // Exit
                    System.out.println("Saving your progress...");
                    currentUser.saveUserData(); // Placeholder
                    System.out.println("Exiting program. Goodbye, " + currentUser.getUsername() + "!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running) {
                System.out.print("\nPress Enter to return to the main menu or type 'exit' to quit: ");
                String continueChoice = scanner.nextLine();
                if (continueChoice.equalsIgnoreCase("exit")) {
                     System.out.println("Saving your progress...");
                    currentUser.saveUserData(); // Placeholder
                    System.out.println("Exiting program. Goodbye, " + currentUser.getUsername() + "!");
                    running = false;
                }
            }
        }
        scanner.close();
    }
}
