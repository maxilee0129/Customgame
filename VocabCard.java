import java.util.ArrayList;
import java.util.Date; // For reviewHistory or nextReviewDate if you implement it fully
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
class VocabCard {
    private int cardId;
    private String word;
    private String translation;
    private String pronunciation;
    private String exampleSentence;
    private String difficulty; // e.g., "Easy", "Medium", "Hard"
    private ArrayList<String> reviewHistory; // Or ArrayList<Date>

    public VocabCard(String word, String translation, String pronunciation, String exampleSentence, String difficulty) {
        this.cardId = IdGenerator.generateCardId();
        this.word = word;
        this.translation = translation;
        this.pronunciation = pronunciation;
        this.exampleSentence = exampleSentence;
        this.difficulty = difficulty;
        this.reviewHistory = new ArrayList<>();
    }

    // Getters
    public int getCardId() { return cardId; }
    public String getWord() { return word; }
    public String getTranslation() { return translation; }
    public String getPronunciation() { return pronunciation; }
    public String getExampleSentence() { return exampleSentence; }
    public String getDifficulty() { return difficulty; }
    public ArrayList<String> getReviewHistory() { return reviewHistory; }

    // Setters (for updating card details)
    public void setWord(String word) { this.word = word; }
    public void setTranslation(String translation) { this.translation = translation; }
    public void setPronunciation(String pronunciation) { this.pronunciation = pronunciation; }
    public void setExampleSentence(String exampleSentence) { this.exampleSentence = exampleSentence; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public void calculateNextReviewDate() {
        // Placeholder: Implement spaced repetition logic if desired
        System.out.println("Method calculateNextReviewDate() called for card: " + word);
        // Example: reviewHistory.add("Reviewed on " + new Date() + " - Correct");
    }

    public void updatePerformance(boolean learnedWell) {
        // Placeholder: Update review history based on performance
        System.out.println("Method updatePerformance() called for card: " + word);
        if (learnedWell) {
            reviewHistory.add("Successfully reviewed on " + new Date().toString());
        } else {
            reviewHistory.add("Review attempt on " + new Date().toString() + " - needs more practice");
        }
    }

    public void generateContextualInfo() {
        // Placeholder: Could fetch more examples, images, etc. (advanced)
        System.out.println("Method generateContextualInfo() called for card: " + word);
    }

    @Override
    public String toString() {
        return "Card ID: " + cardId + "\n Word: " + word + "\n Translation: " + translation +
               "\n Pronunciation: " + (pronunciation != null && !pronunciation.isEmpty() ? pronunciation : "N/A") +
               "\n Example: " + (exampleSentence != null && !exampleSentence.isEmpty() ? exampleSentence : "N/A") +
               "\n Difficulty: " + difficulty;
    }
}
