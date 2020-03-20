package lopatin.task1;

import java.util.LinkedList;
import java.util.List;

/**
 * Задание 1. Написать код, который будет выбрасывать java.lang.OutOfMemoryError, при ограничении heap 20мб (-Xmx20m)
 */
public class Main {
    public static void main(String[] args) {
        List<Object[]> list = new LinkedList<>();
        for (; ; ) {
            list.add(new Object[100]);
        }
    }
}
