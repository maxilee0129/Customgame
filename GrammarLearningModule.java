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

class GrammarLearningModule {
    private User currentUser;
    private Scanner scanner;
    // MODES
    private static final String[] GRAMMAR_MODES = {
        "Verb Conjugation Trainer", "Sentence Structure Analyzer",
        "Parts of Speech Challenge", "Contextual Grammar Game",
        "Syntax Transformation Exercise"
    };

    public GrammarLearningModule(User currentUser, Scanner scanner) {
        this.currentUser = currentUser;
        this.scanner = scanner;
    }

    public void start() {
        selectGrammarMode();
    }

    public void selectGrammarMode() {
        System.out.println("\n--- Select Grammar Learning Mode ---");
        for (int i = 0; i < GRAMMAR_MODES.length; i++) {
            System.out.println((i + 1) + ". " + GRAMMAR_MODES[i]);
        }
        System.out.print("Choose a grammar mode: ");
        int modeChoice = Integer.parseInt(scanner.nextLine());

        if (modeChoice > 0 && modeChoice <= GRAMMAR_MODES.length) {
            String chosenMode = GRAMMAR_MODES[modeChoice - 1];
            System.out.println("Starting Grammar Mode: " + chosenMode);
            // Call specific methods based on chosenMode
            presentGrammarConcept(chosenMode);
            evaluateUserUnderstanding();
            provideDetailedFeedback();
            trackGrammaticalProgress();
        } else {
            System.out.println("Invalid mode choice.");
        }
    }

    public void presentGrammarConcept(String mode) {
        // Placeholder: Display grammar rules/examples based on mode
        System.out.println("Method presentGrammarConcept() for " + mode + " called.");
    }

    public void evaluateUserUnderstanding() {
        // Placeholder: Quizzes, exercises
        System.out.println("Method evaluateUserUnderstanding() called.");
    }

    public void provideDetailedFeedback() {
        // Placeholder: Explain errors, give tips
        System.out.println("Method provideDetailedFeedback() called.");
    }

    public void trackGrammaticalProgress() {
        // Placeholder: Record progress in grammar skills
        System.out.println("Method trackGrammaticalProgress() called.");
        currentUser.updateLearningProgress();
    }
}
