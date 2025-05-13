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
class VocabularyManagementMode {
    private User currentUser;
    private Scanner scanner;

    public VocabularyManagementMode(User currentUser, Scanner scanner) {
        this.currentUser = currentUser;
        this.scanner = scanner;
    }

    public void displayOptions() {
        boolean keepManaging = true;
        while (keepManaging) {
            System.out.println("\n--- Vocabulary Management ---");
            System.out.println("1. Create New Vocabulary List");
            System.out.println("2. View Existing Lists");
            System.out.println("3. Edit List (Add/Remove/Update Cards)");
            System.out.println("4. Delete List");
            System.out.println("5. Import External List (Placeholder)");
            System.out.println("6. Export List (Placeholder)");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createNewVocabularyList();
                    break;
                case "2":
                    viewExistingLists();
                    break;
                case "3":
                    editList();
                    break;
                case "4":
                    deleteList();
                    break;
                case "5":
                    importExternalList();
                    break;
                case "6":
                    exportList();
                    break;
                case "7":
                    keepManaging = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void createNewVocabularyList() {
        System.out.println("\n--- Create New Vocabulary List ---");
        System.out.print("Enter list name: ");
        String name = scanner.nextLine();
        System.out.print("Enter language: ");
        String lang = scanner.nextLine();
        System.out.print("Enter difficulty/category: ");
        String diff = scanner.nextLine();

        VocabularyList newList = new VocabularyList(name, lang, diff);
        currentUser.addVocabularyList(newList);
        System.out.println("List '" + name + "' created successfully.");
    }

    public void viewExistingLists() {
        System.out.println("\n--- Your Vocabulary Lists ---");
        if (currentUser.getVocabularyLists().isEmpty()) {
            System.out.println("You have no vocabulary lists yet.");
            return;
        }
        for (int i = 0; i < currentUser.getVocabularyLists().size(); i++) {
            System.out.println((i + 1) + ". " + currentUser.getVocabularyLists().get(i).toString());
        }
    }

    public void editList() {
        viewExistingLists();
        if (currentUser.getVocabularyLists().isEmpty()) return;

        System.out.print("Enter the number of the list to edit: ");
        int listNum = Integer.parseInt(scanner.nextLine()) - 1;

        if (listNum >= 0 && listNum < currentUser.getVocabularyLists().size()) {
            VocabularyList listToEdit = currentUser.getVocabularyLists().get(listNum);
            System.out.println("Editing list: " + listToEdit.getListName());
            
            boolean keepEditingList = true;
            while(keepEditingList) {
                System.out.println("\nEditing List: " + listToEdit.getListName());
                System.out.println("1. Add Vocab Card");
                System.out.println("2. Remove Vocab Card");
                System.out.println("3. Update Vocab Card");
                System.out.println("4. View Cards in this List");
                System.out.println("5. Done Editing List");
                System.out.print("Choose an option: ");
                String editChoice = scanner.nextLine();

                switch(editChoice) {
                    case "1":
                        System.out.print("Enter word: ");
                        String word = scanner.nextLine();
                        System.out.print("Enter translation: ");
                        String translation = scanner.nextLine();
                        System.out.print("Enter pronunciation (optional): ");
                        String pronunciation = scanner.nextLine();
                        System.out.print("Enter example sentence (optional): ");
                        String example = scanner.nextLine();
                        System.out.print("Enter difficulty: ");
                        String cardDiff = scanner.nextLine();
                        listToEdit.addVocabCard(new VocabCard(word, translation, pronunciation, example, cardDiff));
                        break;
                    case "2":
                        listToEdit.displayCards();
                        System.out.print("Enter Card ID to remove: ");
                        int cardIdRemove = Integer.parseInt(scanner.nextLine());
                        listToEdit.removeVocabCard(cardIdRemove);
                        break;
                    case "3":
                        listToEdit.displayCards();
                        listToEdit.updateCard(scanner);
                        break;
                    case "4":
                        listToEdit.displayCards();
                        break;
                    case "5":
                        keepEditingList = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } else {
            System.out.println("Invalid list number.");
        }
    }

    public void deleteList() {
        viewExistingLists();
        if (currentUser.getVocabularyLists().isEmpty()) return;

        System.out.print("Enter the number of the list to delete: ");
        int listNumDel = Integer.parseInt(scanner.nextLine()) -1;
         if (listNumDel >= 0 && listNumDel < currentUser.getVocabularyLists().size()) {
            String listNameToDelete = currentUser.getVocabularyLists().get(listNumDel).getListName();
            System.out.print("Are you sure you want to delete list '" + listNameToDelete + "'? (yes/no): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                currentUser.removeVocabularyList(listNameToDelete); // Assumes remove by name, better to remove by object or ID if available
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Invalid list number.");
        }
    }

    public void importExternalList() {
        // Placeholder: Call a method on a VocabularyList or User object
        System.out.println("Method importExternalList() called.");
        // Example: selectedList.importList(filePath);
    }

    public void exportList() {
        viewExistingLists();
        if (currentUser.getVocabularyLists().isEmpty()) return;

        System.out.print("Enter the number of the list to export: ");
        int listNumExport = Integer.parseInt(scanner.nextLine()) - 1;

        if (listNumExport >= 0 && listNumExport < currentUser.getVocabularyLists().size()) {
            currentUser.getVocabularyLists().get(listNumExport).exportList();
        } else {
            System.out.println("Invalid list number.");
        }
    }
}
