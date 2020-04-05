package lopatin;

public class Main {
    private static final String UUIDPATH = "src/main/resources/uuidList.txt";
    private static final String SAUSAGEPATH = "src/main/resources/sausageList.txt";

    public static void main(String[] args) {
        UuidUtil uuidUtil = new UuidUtil();
        Doomsday doomsday = new Doomsday();
        SausageUtil sausageUtil = new SausageUtil();
        uuidUtil.fileWrite(UUIDPATH, uuidUtil.generate());
        doomsday.generate(uuidUtil.uuidCounter(UUIDPATH));
        sausageUtil.fileRead(SAUSAGEPATH);
    }
}
