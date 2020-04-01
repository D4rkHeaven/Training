package extraTasks;

public class Main {
    private static final String PATH = "src/main/resources/humanValues.txt";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setHumanValues();
        fileHandler.setPeopleValues(PATH);
        fileHandler.searchClassesWithAnnotation();
    }
}
