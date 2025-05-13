import java.util.ArrayList;
import java.util.HashMap; // For userPreferences
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
class User {
    private int userId;
    private String username;
    private String password; // For authentication
    private String email;
    private ArrayList<String> languagesLearning;
    private ArrayList<VocabularyList> vocabularyLists;
    // learningStatistics could be a complex object or handled by StatisticsTracker
    private HashMap<String, String> userPreferences;

    // Constructor for new user signup
    public User(String username, String password, String email) {
        this.userId = IdGenerator.generateUserId();
        this.username = username;
        this.password = password; // Store password (hashed in real app)
        this.email = email;
        this.languagesLearning = new ArrayList<>();
        this.vocabularyLists = new ArrayList<>();
        this.userPreferences = new HashMap<>();
        System.out.println("User profile created for: " + username);
    }

    // Getters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public ArrayList<String> getLanguagesLearning() { return languagesLearning; }
    public ArrayList<VocabularyList> getVocabularyLists() { return vocabularyLists; }
    public HashMap<String, String> getUserPreferences() { return userPreferences; }

    // Methods
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    
    public void addLanguageLearning(String language) {
        if (!languagesLearning.contains(language)) {
            languagesLearning.add(language);
            System.out.println(language + " added to learning languages.");
        } else {
            System.out.println(language + " is already in your learning list.");
        }
    }

    public void addVocabularyList(VocabularyList list) {
        this.vocabularyLists.add(list);
    }
    
    public VocabularyList findVocabularyList(String listName) {
        for (VocabularyList list : vocabularyLists) {
            if (list.getListName().equalsIgnoreCase(listName)) {
                return list;
            }
        }
        return null;
    }
    
    public void removeVocabularyList(String listName) {
        VocabularyList listToRemove = findVocabularyList(listName);
        if (listToRemove != null) {
            vocabularyLists.remove(listToRemove);
            System.out.println("Vocabulary list '" + listName + "' removed.");
        } else {
            System.out.println("Vocabulary list '" + listName + "' not found.");
        }
    }

    public void saveUserData() {
        // Placeholder: Implement data persistence (e.g., save to a file)
        System.out.println("Method saveUserData() called for user: " + username);
        System.out.println("Data for " + username + " would be saved here.");
        // Example: Could serialize the User object or write to a CSV/JSON
    }

    public void loadUserData() {
        // Placeholder: Implement data loading (e.g., load from a file)
        System.out.println("Method loadUserData() called for user: " + username);
        // Example: Could deserialize or parse from CSV/JSON to populate lists
    }

    public void updateLearningProgress() {
        // Placeholder: This could update internal stats or interact with StatisticsTracker
        System.out.println("Method updateLearningProgress() called for user: " + username);
    }

    @Override
    public String toString() {
        return "User: " + username + " (ID: " + userId + "), Email: " + email;
    }
}
