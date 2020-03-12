package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private static final int HIGHEST_ALLOWED_ID = 100;
    private Converter converter = new Converter();
    private Repository repository = new Repository();
    private Logger fileLogger = LoggerFactory.getLogger(Service.class);
    // Получение сущности из БД через ДТО
    public HumanDTO get(HumanDTO dto) {
        Human human = converter.ConvertToHuman(dto);
        try{
            repository.get(human);
            fileLogger.info("Сущность с id = {} получена из БД", dto.getID());
        }catch(EntityNotFound e){
            fileLogger.warn("Exception: ",e);
        }
        return converter.ConvertToDTO(human);
    }

    // Получение списка сущностей из БД через DTO
    public List<HumanDTO> getAll(int i) throws EntityNotFound {
        List<HumanDTO> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDTO dto = new HumanDTO();
            dto=get(dto);
            if(dto.getID()>HIGHEST_ALLOWED_ID){
                fileLogger.warn("Человек с id = {} не найден", dto.getID());
                throw new EntityNotFound("Человек с id"+ dto.getID()+" не найден");
            }
            list.add(dto);
        }
        return list;
    }

    // Сохранение ДТО в БД путём конвертации в human
    public void save(HumanDTO dto) {
        Human human=converter.ConvertToHuman(dto);
        try {
            repository.save(human);
            fileLogger.info("Сущность с id = {} сохранена в БД", dto.getID());
        } catch (CannotSaveEntity e){
            fileLogger.warn("Exception: ",e);
        }
    }

    // Сохранение всех ДТО в БД
    public void saveAll(List<HumanDTO> dtos) {
        for (HumanDTO dto : dtos) {
            try {
                Human human = converter.ConvertToHuman(dto);
                repository.save(human);
            } catch (CannotSaveEntity e){
             fileLogger.warn("Exception: ",e);
        }
        }
    }
}
