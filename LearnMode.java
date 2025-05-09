import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class LearnMode {
    private User currentUser;
    private VocabularyList selectedList;
    private Scanner scanner;
    // LEARNING METHODS (as constants or enum)
    private static final String[] LEARNING_METHODS = {
        "Flashcards", "Multiple Choice", "Written Response", "Timed Challenge",
        "Word Association", "Spelling Bee", "Story Creation",
        "Survival Language Scenario", "Vocabulary Detective"
    };

    public LearnMode(User currentUser, Scanner scanner) {
        this.currentUser = currentUser;
        this.scanner = scanner;
    }

    public void selectAndStart() {
        if (currentUser.getVocabularyLists().isEmpty()) {
            System.out.println("No vocabulary lists available. Please create one first.");
            return;
        }

        System.out.println("\n--- Select Vocabulary List for Learning ---");
        for (int i = 0; i < currentUser.getVocabularyLists().size(); i++) {
            System.out.println((i + 1) + ". " + currentUser.getVocabularyLists().get(i).getListName());
        }
        System.out.print("Choose a list number: ");
        int listChoice = Integer.parseInt(scanner.nextLine()) - 1;

        if (listChoice >= 0 && listChoice < currentUser.getVocabularyLists().size()) {
            this.selectedList = currentUser.getVocabularyLists().get(listChoice);
            if (selectedList.getVocabCards().isEmpty()) {
                System.out.println("Selected list '" + selectedList.getListName() + "' has no cards. Add some cards first.");
                return;
            }
            selectLearningMethod();
        } else {
            System.out.println("Invalid list choice.");
        }
    }


    public void selectLearningMethod() {
        System.out.println("\n--- Select Learning Method for list: " + selectedList.getListName() + " ---");
        for (int i = 0; i < LEARNING_METHODS.length; i++) {
            System.out.println((i + 1) + ". " + LEARNING_METHODS[i]);
        }
        System.out.print("Choose a learning method: ");
        int methodChoice = Integer.parseInt(scanner.nextLine());

        if (methodChoice > 0 && methodChoice <= LEARNING_METHODS.length) {
            String chosenMethod = LEARNING_METHODS[methodChoice - 1];
            System.out.println("Starting Learn Mode with: " + chosenMethod);
            startSession(chosenMethod);
        } else {
            System.out.println("Invalid method choice.");
        }
    }

    public void startSession(String learningMethod) {
        System.out.println("\n--- Learn Session Started: " + learningMethod + " for list '" + selectedList.getListName() + "' ---");
        // Shuffle cards for variety
        ArrayList<VocabCard> sessionCards = new ArrayList<>(selectedList.getVocabCards());
        Collections.shuffle(sessionCards);

        switch (learningMethod) {
            case "Flashcards":
                runFlashcards(sessionCards);
                break;
            case "Multiple Choice":
                System.out.println("Multiple Choice mode not yet implemented.");
                break;
            // Add cases for other learning methods
            default:
                System.out.println(learningMethod + " mode not yet fully implemented.");
                break;
        }
        trackPerformance();
        adaptDifficulty();
        generateSessionReport();
        currentUser.updateLearningProgress(); // Notify user object
    }

    private void runFlashcards(ArrayList<VocabCard> cards) {
        if (cards.isEmpty()) {
            System.out.println("No cards to study in this list!");
            return;
        }
        System.out.println("Flashcard Mode: Press Enter to reveal translation. Type 'n' for next, 'q' to quit.");
        for (VocabCard card : cards) {
            System.out.println("\nWord: " + card.getWord());
            if (card.getPronunciation() != null && !card.getPronunciation().isEmpty()) {
                 System.out.println("Pronunciation: " + card.getPronunciation());
            }
            if (card.getExampleSentence() != null && !card.getExampleSentence().isEmpty()) {
                 System.out.println("Example: " + card.getExampleSentence());
            }
            System.out.print("Press Enter to see translation...");
            scanner.nextLine(); // Wait for user to press Enter

            System.out.println("Translation: " + card.getTranslation());
            
            System.out.print("Did you know it? (y/n): ");
            String known = scanner.nextLine().trim().toLowerCase();
            card.updatePerformance(known.equals("y"));


            System.out.print("Next card? (Enter for next, 'q' to quit flashcards): ");
            String command = scanner.nextLine().trim().toLowerCase();
            if (command.equals("q")) {
                break;
            }
        }
        System.out.println("Flashcard session finished.");
    }


    public void trackPerformance() {
        // Placeholder: Implement performance tracking logic
        System.out.println("Method trackPerformance() called.");
    }

    public void adaptDifficulty() {
        // Placeholder: Implement adaptive difficulty logic
        System.out.println("Method adaptDifficulty() called.");
    }

    public void generateSessionReport() {
        // Placeholder: Generate and display a report of the session
        System.out.println("Method generateSessionReport() called.");
        System.out.println("Session for list '" + (selectedList != null ? selectedList.getListName() : "N/A") + "' completed.");
    }
}
