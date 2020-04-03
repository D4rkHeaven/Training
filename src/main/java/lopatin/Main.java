package lopatin;

public class Main {
    private static final String PATH = "src/main/resources/uuidList.txt";

    public static void main(String[] args) {
        UuidUtil uuidUtil = new UuidUtil();
        Doomsday doomsday = new Doomsday();
        uuidUtil.fileWrite(PATH, uuidUtil.generate());
        uuidUtil.uuidCounter(PATH);
        doomsday.generate(90);
    }
}
