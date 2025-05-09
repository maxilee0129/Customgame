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
