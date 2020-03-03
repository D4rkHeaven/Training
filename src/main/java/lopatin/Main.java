package lopatin;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Проверка интерфейса");
        Human human = new Human();
        Interface.get(human);
        Interface.save(human);
        List<Human> persons = Interface.getAll(3);
        Interface.saveAll(persons);


        System.out.println("Проверка сервиса");
        HumanDTO dto = new HumanDTO();
        Service.get(dto);
        Service.save(dto);
        List<HumanDTO> dtos = Service.getAll(3);
        Service.saveAll(dtos);

        // перевод из сущности в дто
        System.out.println("Проверка конвертера");
        dto = Converter.ConvertToDTO(human);
        Interface.save(human);
        Service.save(dto);
        // перевод из дто в сущность
        Service.get(dto);
        human = Converter.ConvertToHuman(dto);
        Service.save(dto);
        Interface.save(human);
    }
}
