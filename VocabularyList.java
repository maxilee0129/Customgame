import java.util.ArrayList;
import java.util.Scanner;

class VocabularyList {
    private int listId;
    private String listName;
    private String language;
    private String difficulty; // Overall difficulty or category for the list
    private ArrayList<VocabCard> vocabCards;

    public VocabularyList(String listName, String language, String difficulty) {
        this.listId = IdGenerator.generateListId();
        this.listName = listName;
        this.language = language;
        this.difficulty = difficulty;
        this.vocabCards = new ArrayList<>();
    }

    // Getters
    public int getListId() { return listId; }
    public String getListName() { return listName; }
    public String getLanguage() { return language; }
    public String getDifficulty() { return difficulty; }
    public ArrayList<VocabCard> getVocabCards() { return vocabCards; }

    // Setters
    public void setListName(String listName) { this.listName = listName; }
    public void setLanguage(String language) { this.language = language; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }


    public void addVocabCard(VocabCard card) {
        this.vocabCards.add(card);
        System.out.println("Card '" + card.getWord() + "' added to list '" + this.listName + "'.");
    }

    public void removeVocabCard(int cardId) {
        VocabCard cardToRemove = null;
        for (VocabCard card : vocabCards) {
            if (card.getCardId() == cardId) {
                cardToRemove = card;
                break;
            }
        }
        if (cardToRemove != null) {
            vocabCards.remove(cardToRemove);
            System.out.println("Card ID " + cardId + " removed from list '" + this.listName + "'.");
        } else {
            System.out.println("Card ID " + cardId + " not found in list '" + this.listName + "'.");
        }
    }

    public VocabCard findVocabCard(int cardId) {
        for (VocabCard card : vocabCards) {
            if (card.getCardId() == cardId) {
                return card;
            }
        }
        return null;
    }
    
    public void updateCard(Scanner scanner) {
        System.out.print("Enter Card ID to update: ");
        int cardIdToUpdate = Integer.parseInt(scanner.nextLine());
        VocabCard card = findVocabCard(cardIdToUpdate);

        if (card != null) {
            System.out.println("Found card: " + card.getWord());
            System.out.print("New word (enter to keep current: '" + card.getWord() + "'): ");
            String newWord = scanner.nextLine();
            if (!newWord.isEmpty()) card.setWord(newWord);

            System.out.print("New translation (enter to keep current: '" + card.getTranslation() + "'): ");
            String newTranslation = scanner.nextLine();
            if (!newTranslation.isEmpty()) card.setTranslation(newTranslation);
            
            System.out.print("New pronunciation (enter to keep current: '" + card.getPronunciation() + "'): ");
            String newPronunciation = scanner.nextLine();
            if (!newPronunciation.isEmpty()) card.setPronunciation(newPronunciation);

            System.out.print("New example sentence (enter to keep current: '" + card.getExampleSentence() + "'): ");
            String newExample = scanner.nextLine();
            if (!newExample.isEmpty()) card.setExampleSentence(newExample);

            System.out.print("New difficulty (enter to keep current: '" + card.getDifficulty() + "'): ");
            String newDifficulty = scanner.nextLine();
            if (!newDifficulty.isEmpty()) card.setDifficulty(newDifficulty);

            System.out.println("Card updated.");
        } else {
            System.out.println("Card not found.");
        }
    }

    public void exportList() {
        // Placeholder: Implement file export (e.g., to CSV)
        System.out.println("Method exportList() called for list: " + listName);
        System.out.println("List content:");
        for(VocabCard card : vocabCards) {
            System.out.println(card.getWord() + "," + card.getTranslation() + "," + card.getPronunciation() + "," + card.getExampleSentence() + "," + card.getDifficulty());
        }
    }

    public void importList() {
        // Placeholder: Implement file import
        System.out.println("Method importList() called for list: " + listName);
    }

    public void displayCards() {
        if (vocabCards.isEmpty()) {
            System.out.println("No cards in this list yet.");
            return;
        }
        System.out.println("\n--- Cards in '" + listName + "' ---");
        for (VocabCard card : vocabCards) {
            System.out.println(card);
            System.out.println("-----");
        }
    }

    @Override
    public String toString() {
        return "List ID: " + listId + ", Name: '" + listName + "', Language: '" + language + 
               "', Difficulty: '" + difficulty + "', Cards: " + vocabCards.size();
    }
}
