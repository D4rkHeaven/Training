package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for working with dto. This is layer between user and repository
 */
public class Service {
    private static final int HIGHEST_ALLOWED_ID = 100;
    private Converter converter = new Converter();
    private Repository repository = new Repository();
    private Logger fileLogger = LoggerFactory.getLogger(Service.class);

    /**
     * Get one dto from repository (DB)
     *
     * @param dto from user
     * @return filled dto
     */
    public HumanDto get(HumanDto dto) {
        Human human = converter.ConvertToHuman(dto);
        try {
            repository.get(human);
            fileLogger.info("Сущность с id = {} получена из БД", dto.getId());
        } catch (EntityNotFound e) {
            fileLogger.warn("Exception: ", e);
        }
        return converter.ConvertToDTO(human);
    }

    /**
     * Get list with i dto from repository
     *
     * @param i number of records
     * @return list of dto
     */
    public List<HumanDto> getAll(int i) {
        List<HumanDto> dtoList = new ArrayList<>();
        try {
            List<Human> humanList = repository.getAll(i);
            for (int j = 0; j < i; j++) {
                Human human = humanList.get(j);
                HumanDto dto = converter.ConvertToDTO(human);
                dtoList.add(dto);
            }
        } catch (EntityNotFound e) {
            fileLogger.warn("Exception: ", e);
        }

        return dtoList;
    }

    /**
     * Save dto in DB
     *
     * @param dto - dto from user
     */
    public void save(HumanDto dto) {
        Human human = converter.ConvertToHuman(dto);
        try {
            repository.save(human);
            fileLogger.info("Сущность с id = {} сохранена в БД", dto.getId());
        } catch (CannotSaveEntity e) {
            fileLogger.warn("Exception: ", e);
        }
    }

    /**
     * Save dto list in DB
     *
     * @param dtoList list of dto
     */
    public void saveAll(List<HumanDto> dtoList) {
        for (HumanDto dto : dtoList) {
            try {
                Human human = converter.ConvertToHuman(dto);
                repository.save(human);
            } catch (CannotSaveEntity e) {
                fileLogger.warn("Exception: ", e);
            }
        }
    }
}
