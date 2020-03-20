package lopatin;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for working with dto. This is layer between user and repository
 */
public class Service {
    /**
     * Get one dto from repository (DB)
     *
     * @param dto from user
     * @return filled dto
     */
    public HumanDto get(HumanDto dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human = converter.ConvertToHuman(dto);
        repository.get(human);
        dto = converter.ConvertToDto(human);
        return dto;
    }

    /**
     * Get list with i dto from repository
     *
     * @param i number of records
     * @return list of dto
     */
    public List<HumanDto> getAll(int i) {
        List<HumanDto> dtoList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDto dto = new HumanDto();
            dtoList.add(get(dto));
        }
        return dtoList;
    }

    /**
     * Save dto in DB
     *
     * @param dto - dto from user
     */
    public void save(HumanDto dto) {
        Converter converter = new Converter();
        Repository repository = new Repository();
        Human human = converter.ConvertToHuman(dto);
        repository.save(human);
    }

    /**
     * Save dto list in DB
     *
     * @param dtoList list of dto
     */
    public void saveAll(List<HumanDto> dtoList) {
        for (HumanDto dto : dtoList) {
            Converter converter = new Converter();
            Repository repository = new Repository();
            Human human = converter.ConvertToHuman(dto);
            repository.save(human);
        }
    }
}
