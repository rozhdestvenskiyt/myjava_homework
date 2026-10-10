package task3;

public enum ActionType {

    BASE_ATTACK("Базовая атака"),
    SPECIAL_SKILL("Особое умение"),
    REST("Отдых");

    private final String russianName;

    ActionType(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
