class StatisticsTracker {
    private User currentUser;
    // TRACKING METRICS - these would be calculated based on User's data
    // - Total words learned
    // - Words in progress
    // - Mastery level per list
    // - Time spent learning
    // - Accuracy rates
    // - Grammar skill progression

    public StatisticsTracker(User currentUser) {
        this.currentUser = currentUser;
    }

    public void calculateOverallProgress() {
        // Placeholder: Calculate based on vocabularyLists, reviewHistory etc.
        System.out.println("\n--- Calculating Overall Progress for " + currentUser.getUsername() + " ---");
        int totalCards = 0;
        int cardsMastered = 0; // Define "mastered" e.g. reviewed successfully X times
        for (VocabularyList list : currentUser.getVocabularyLists()) {
            totalCards += list.getVocabCards().size();
            for (VocabCard card : list.getVocabCards()) {
                // Simple check: if review history contains multiple successful reviews
                long successfulReviews = card.getReviewHistory().stream().filter(r -> r.contains("Successfully")).count();
                if (successfulReviews >= 2) { // Arbitrary "mastered" condition
                    cardsMastered++;
                }
            }
        }
        System.out.println("Total vocabulary cards: " + totalCards);
        System.out.println("Cards considered mastered: " + cardsMastered);
        // More detailed calculations can be added
    }

    public void generateDetailedReport() {
        System.out.println("\n--- Detailed Statistics Report for " + currentUser.getUsername() + " ---");
        System.out.println("Method generateDetailedReport() called.");
        calculateOverallProgress(); // Show some basic stats

        System.out.println("\nPer List Statistics:");
        if (currentUser.getVocabularyLists().isEmpty()){
            System.out.println("No lists to report on.");
        } else {
            for(VocabularyList list : currentUser.getVocabularyLists()){
                System.out.println("List: " + list.getListName());
                System.out.println("  Total Cards: " + list.getVocabCards().size());
                // Add more per-list stats (e.g., mastery for this list)
            }
        }
        // This would be much more detailed in a full implementation
    }

    public void visualizeLearningTrends() {
        // Placeholder: ASCII charts or integrate with a library if GUI
        System.out.println("Method visualizeLearningTrends() called.");
    }

    public void comparePerformancePeriods() {
        // Placeholder: Compare stats from different timeframes
        System.out.println("Method comparePerformancePeriods() called.");
    }
}
