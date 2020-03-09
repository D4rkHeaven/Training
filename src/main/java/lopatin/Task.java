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
        User user1=new User("Акопян Владислав", Role.ADMIN);
        User user2=new User("Игнаточкин Андрей", Role.USER);
        User user3=new User("Ситников Олег", Role.MODERATOR);
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

    public void fillArrayList(List<Human> humanList){
        System.out.println("Исходная коллекция:");
        print(humanList);
    }

    public void findDoubles(List<Human> humanList) {
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
    public void deleteDoubles(List<Human> humanList){
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
    public void sortByFio(List<Human> humanList){
        Comparator<Human> compareByFio = Comparator.comparing(Human::getFio);
        humanList.sort(compareByFio);
        System.out.println("Коллекция, отсортированная по ФИО:");
        print(humanList);
    }
    public void sortByAge(List<Human> humanList){
        Comparator<Human> compareByAge = Comparator.comparing(Human::getAge);
        humanList.sort(compareByAge);
        System.out.println("Коллекция, отсортированная по возрасту:");
        print(humanList);
    }
    public void sortByAddress(List<Human> humanList){
        Comparator<Human> compareByAddress = (o1, o2) -> o1.getAddress().compareTo(o2.getAddress());
        humanList.sort(compareByAddress);
        System.out.println("Коллекция, отсортированная по адресу:");
        print(humanList);
    }
    public void createUsers(List<User> users){
        System.out.println("Список пользователей: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i+1)+ " " + users.get(i));
        }
    }
    public void greetUsers(List<User> users){
        Map<String, Role> hashmap = new HashMap<>() ;
        System.out.println("Приветствуем пользователей: ");
        for (int i = 0; i<users.size(); i++) {
            String key=users.get(i).getFio();
            Role role=users.get(i).getRole();
            hashmap.put(key,role);
            System.out.println("Приветствуем " + users.get(i).getFio() + " с ролью " + hashmap.get(key));
        }
    }
    public void sortHashMapByKey(HashMap<Integer,String> map){
        Map<Integer, String> treeMap = new TreeMap<>(map);
        System.out.println("Множество, отсортированное по ключам");
        System.out.println(treeMap);
    }
    public void sortHashMapByValue(HashMap<Integer,String> map){
        TreeSet< String> treeMap = new TreeSet<>(map.values());
        System.out.println("Множество, отсортированное по значениям");
        System.out.println(treeMap);
    }
    public void fillLinkedList(){
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add((int)(Math.random()*100));
        }
        System.out.println("Содержимое двусвязного списка");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(" Значение "+linkedList.get(i)+" c индексом "+(i+1));
        }
    }
}
