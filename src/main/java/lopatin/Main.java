package lopatin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверка интерфейса");
        Human human = new Human();
        Service service = new Service();
        Repository repository = new Repository();
        Converter converter = new Converter();
        service.get(human);
        service.save(human);
        List<Human> persons = service.getAll(3);
        service.saveAll(persons);


        System.out.println("Проверка сервиса");
        HumanDTO dto = new HumanDTO();
        repository.get(dto);
        repository.save(dto);
        List<HumanDTO> dtos = repository.getAll(3);
        repository.saveAll(dtos);

        // перевод из сущности в дто
        System.out.println("Проверка конвертера");
        dto = converter.ConvertToDTO(human);
        service.save(human);
        repository.save(dto);
        // перевод из дто в сущность
        repository.get(dto);
        human = converter.ConvertToHuman(dto);
        repository.save(dto);
        service.save(human);
    }
}
