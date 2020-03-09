package lopatin;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        List<Human> humanList = task.getList();
        List<User> users = task.getUsers();
        HashMap<Integer, String> hashmap = task.getMap();
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введите номер задания (от 1 до 11): ");
            int number = in.nextInt();
            switch (number) {
                case 1:
                    task.fillArrayList(humanList);
                    break;
                case 2:
                    task.findDoubles(humanList);
                    break;
                case 3:
                    task.deleteDoubles(humanList);
                    break;
                case 4:
                    task.sortByFio(humanList);
                    break;
                case 5:
                    task.sortByAge(humanList);
                    break;
                case 6:
                    task.sortByAddress(humanList);
                    break;
                case 7:
                    task.createUsers(users);
                    break;
                case 8:
                    task.greetUsers(users);
                    break;
                case 9:
                    task.sortHashMapByKey(hashmap);
                    break;
                case 10:
                    task.sortHashMapByValue(hashmap);
                    break;
                case 11:
                    task.fillLinkedList();
                    break;
                default:
                    System.out.println("Неправильный номер задания.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.print("Введите число, являющееся номером задания!");
        }
    }
}
