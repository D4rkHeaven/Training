package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private Logger fileLogger = LoggerFactory.getLogger(Service.class);
    // Получение сущности из БД через ДТО
    public HumanDTO get(HumanDTO dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human= converter.ConvertToHuman(dto);
        repository.get(human);
        dto = converter.ConvertToDTO(human);
        fileLogger.info("Сущность с id = {} получена из БД", dto.getID());
        return dto;
    }

    // Получение списка сущностей из БД через DTO
     public List<HumanDTO> getAll(int i) {
        List<HumanDTO> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDTO dto = new HumanDTO();
            list.add(get(dto));
        }
        return list;
    }

    // Сохранение ДТО в БД путём конвертации в human
     public void save(HumanDTO dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human=converter.ConvertToHuman(dto);
        fileLogger.info("Сущность с id = {} сохранена в БД", dto.getID());
        repository.save(human);
    }

    // Сохранение всех ДТО в БД
     public void saveAll(List<HumanDTO> dtos) {
        for (HumanDTO dto : dtos) {
            Converter converter = new Converter();
            Repository repository = new Repository();
            Human human=converter.ConvertToHuman(dto);
            repository.save(human);
        }
    }
}
