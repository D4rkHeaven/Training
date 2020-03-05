package lopatin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверка интерфейса");
        Human human = new Human();
        Interface inter = new Interface<>();
        Service service = new Service<>();
        Converter converter = new Converter<>();
        inter.get(human);
        inter.save(human);
        List<Human> persons = inter.getAll(3);
        inter.saveAll(persons);


        System.out.println("Проверка сервиса");
        HumanDTO dto = new HumanDTO();
        service.get(dto);
        service.save(dto);
        List<HumanDTO> dtos = service.getAll(3);
        service.saveAll(dtos);

        // перевод из сущности в дто
        System.out.println("Проверка конвертера");
        dto = converter.ConvertToDTO(human);
        inter.save(human);
        service.save(dto);
        // перевод из дто в сущность
        service.get(dto);
        human = converter.ConvertToHuman(dto);
        service.save(dto);
        inter.save(human);
    }
}
