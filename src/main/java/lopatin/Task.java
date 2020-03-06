package lopatin;

import java.util.*;

public class Task {
    private void print(List<Human> humanList){
        for (int i = 0; i < humanList.size(); i++) {
            System.out.println((i+1)+ " " + humanList.get(i));
        }
    }
    public List<Human> getList(){
        Human.Address address1 = new Human().new Address("Москва","Ленина",12,1);
        Human human1 = new Human("Пупкин Г.Д.",12,address1);
        Human.Address address2 = new Human().new Address("Москва","Ленина",12,1);
        Human human2 = new Human("Пупкин Г.Д.",12,address2);
        Human.Address address3 = new Human().new Address("Тольятти","Мира",24,4);
        Human human3 = new Human("Астапов В.Д.",26,address3);
        Human.Address address4 = new Human().new Address("Тольятти","Мира",24,4);
        Human human4 = new Human("Астапов В.Д.",26,address4);
        Human.Address address5 = new Human().new Address("Казань","Советская",91,43);
        Human human5 = new Human("Гайнулин О.В.",44,address5);
        Human.Address address6 = new Human().new Address("Казань","Советская",91,43);
        Human human6 = new Human("Гайнулин О.В.",44,address6);
        Human.Address address7 = new Human().new Address("Санкт-Петербург","Революционная",1,47);
        Human human7 = new Human("Бердяев А.Д.",32,address7);
        Human.Address address8 = new Human().new Address("Омск","Свободы",61,32);
        Human human8 = new Human("Филимонов О.Д.",15,address8);
        Human.Address address9 = new Human().new Address("Рязань","Северная",21,39);
        Human human9 = new Human("Пушкин В.А.",22,address9);
        Human.Address address10 = new Human().new Address("Санкт-петербург","Раскольникова",66,1);
        Human human10 = new Human("Фауст В.И.",21,address10);
        List<Human> humanList=new ArrayList<>();
        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);
        humanList.add(human4);
        humanList.add(human5);
        humanList.add(human6);
        humanList.add(human7);
        humanList.add(human8);
        humanList.add(human9);
        humanList.add(human10);
        return humanList;
    }
    public List<User> getUsers(){
        User user1=new User("Акопян Владислав", User.Role.ADMIN);
        User user2=new User("Игнаточкин Андрей", User.Role.USER);
        User user3=new User("Ситников Олег", User.Role.MODERATOR);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
    public HashMap<Integer,String> getMap(){
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"one");
        map.put(5,"two");
        map.put(12,"three");
        map.put(33,"four");
        map.put(3,"five");
        map.put(92,"six");
        map.put(84,"seven");
        map.put(11,"eight");
        map.put(37,"nine");
        map.put(74,"ten");
        return map;
    }

    public void runTask1(List<Human> humanList){
        System.out.println("Исходная коллекция:");
        print(humanList);
    }

    public void runTask2(List<Human> humanList) {
        Map<Human, Integer> mapHuman = new HashMap<>();
        for (Human human : humanList) {
            mapHuman.put(human,mapHuman.get(human)==null?1:mapHuman.get(human)+1);
        }
        System.out.println("Найдены следующие дубли в коллекции:");
        for (Map.Entry<Human, Integer> entry : mapHuman.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
    public void runTask3(List<Human> humanList){
        Map<Human, Integer> mapHuman = new HashMap<>();
        for (Human human : humanList) {
            mapHuman.put(human,mapHuman.get(human)==null?1:mapHuman.get(human)+1);
        }
        for (Map.Entry<Human, Integer> entry : mapHuman.entrySet()) {
            if (entry.getValue()>1) {
                Human h = entry.getKey();
                humanList.remove(h);
            }
        }
        System.out.println("Коллекция без дублей:");
        print(humanList);
    }
    public void runTask4(List<Human> humanList){
        Comparator<Human> compareByFio = Comparator.comparing(Human::getFio);
        humanList.sort(compareByFio);
        System.out.println("Коллекция, отсортированная по ФИО:");
        print(humanList);
    }
    public void runTask5(List<Human> humanList){
        Comparator<Human> compareByAge = Comparator.comparing(Human::getAge);
        humanList.sort(compareByAge);
        System.out.println("Коллекция, отсортированная по возрасту:");
        print(humanList);
    }
    public void runTask6(List<Human> humanList){
        Comparator<Human> compareByAddress = (o1, o2) -> o1.getAddress().compareTo(o2.getAddress());
        humanList.sort(compareByAddress);
        System.out.println("Коллекция, отсортированная по адресу:");
        print(humanList);
    }
    public void runTask7(List<User> users){
        System.out.println("Список пользователей: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i+1)+ " " + users.get(i));
        }
    }
    public void runTask8(List<User> users){
        System.out.println("Приветствуем пользователей: ");
        for (User value : users) {
            User user = new User();
            user.greeting(value);
        }
    }
    public void runTask9(HashMap<Integer,String> map){
        Map<Integer, String> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);
    }
    public void runTask10(HashMap<Integer,String> map){
        TreeSet< String> treeMap = new TreeSet<>(map.values());
        System.out.println(treeMap);
    }
    public void runTask11(){
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList);
    }
}
