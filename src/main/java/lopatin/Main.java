package lopatin;

import lombok.extern.slf4j.Slf4j;
import lopatin.filter.Filter;
import lopatin.util.InvalidCommandException;

import java.util.Scanner;
@Slf4j
public class Main {
    public static void main(String[] args) {

        System.out.println("Введите команду");
        Scanner scanner = new Scanner(System.in);
        String command;
        Filter filter = new Filter();
        while (true) {
            try {
                command = scanner.nextLine();
                filter.execute(command);
            } catch (InvalidCommandException e) {
                log.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
