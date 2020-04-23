package lopatin;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        dbUtil.connect();
        log.info("Connected to database.");
        boolean menu = true;
        while (menu) {
            System.out.println("Choose command: 1,2,3,4,5");
            System.out.println("1. Add new record");
            System.out.println("2. Change specified record");
            System.out.println("3. Search specified record");
            System.out.println("4. Delete specified record");
            System.out.println("5. Exit");

            Scanner sc = new Scanner(System.in);

            int choose = sc.nextInt();
            switch (choose) {
                case (1): {
                    log.info("User choose add command.");
                    System.out.println("Input title of new record");
                    String title = new Scanner(System.in).nextLine();
                    dbUtil.add(title);
                    log.info("User added record with {} title.", title);
                    break;
                }
                case (2): {
                    log.info("User choose change command.");
                    System.out.println("Input product_id.");
                    int productId = sc.nextInt();
                    System.out.println("Input title.");
                    String title = new Scanner(System.in).nextLine();
                    dbUtil.change(title, productId);
                    log.info("User changed record with {} id. Now it calls {}.", productId, title);
                    break;
                }
                case (3): {
                    log.info("User choose search command.");
                    System.out.println("Input title.");
                    String title = new Scanner(System.in).nextLine();
                    dbUtil.search(title);
                    log.info("User searched record with {} product_id.", title);
                    break;
                }
                case (4): {
                    log.info("User choose delete command.");
                    System.out.println("Input product_id");
                    int productId = sc.nextInt();
                    dbUtil.delete(productId);
                    log.info("User deleted record with {} product_id.", productId);
                    break;
                }
                case (5): {
                    log.info("User choose exit from system.");
                    menu = false;
                }
            }
        }
        dbUtil.disconnect();
        log.info("Disconnected from database");
    }
}
