package lopatin;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        List<Human> humanList = task.getList();
        List<User> users = task.getUsers();
        HashMap<Integer,String> hashmap=task.getMap();
        Scanner in = new Scanner(System.in);

        System.out.print("Введите номер задания (от 1 до 11): ");
        int number = in.nextInt();
        switch (number) {
            case 1: task.runTask1(humanList);
                break;
            case 2: task.runTask2(humanList);
                break;
            case 3: task.runTask3(humanList);
                break;
            case 4: task.runTask4(humanList);
                break;
            case 5: task.runTask5(humanList);
                break;
            case 6:  task.runTask6(humanList);
                break;
            case 7: task.runTask7(users);
                break;
            case 8: task.runTask8(users);
                break;
            case 9: task.runTask9(hashmap);
                break;
            case 10: task.runTask10(hashmap);
                break;
            case 11: task.runTask11();
                break;
            default:
                System.out.println("Неправильный номер задания.");
                break;
        }
    }
}
