package lopatin;

import java.util.ArrayList;
import java.util.List;

public class Service {

    // Получение сущности из БД через ДТО
    HumanDTO get(HumanDTO dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human= converter.ConvertToHuman(dto);
        repository.get(human);
        dto = converter.ConvertToDTO(human);
        return dto;
    }

    // Получение списка сущностей из БД через DTO
     List<HumanDTO> getAll(int i) {
         Service service = new Service();
        List<HumanDTO> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDTO dto = new HumanDTO();
            list.add(service.get(dto));
        }
        return list;
    }

    // Сохранение ДТО в БД путём конвертации в human
     void save(HumanDTO dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human=converter.ConvertToHuman(dto);
        repository.save(human);
    }

    // Сохранение всех ДТО в БД
     void saveAll(List<HumanDTO> dtos) {
        for (HumanDTO dto : dtos) {
            Converter converter = new Converter();
            Repository repository = new Repository();
            Human human=converter.ConvertToHuman(dto);
            repository.save(human);
        }
    }
}
