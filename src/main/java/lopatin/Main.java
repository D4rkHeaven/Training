package lopatin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tasks task = new Tasks();
        List<Human> humanList = task.runTask1();
        task.runTask2(humanList);
        task.runTask3(humanList);
        task.runTask4(humanList);
        task.runTask5(humanList);
        task.runTask6(humanList);
    }
}
