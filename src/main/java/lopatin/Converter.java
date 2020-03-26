package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts human to dto and vice versa
 */
public class Converter {
    private Logger consoleLogger = LoggerFactory.getLogger(Converter.class);

    public Human ConvertToHuman(HumanDto dto) {
        Human human = new Human();
        human.setId(dto.getId());
        human.setName(dto.getName());
        human.setBirthDate(dto.getBirthDate());
        human.setAddress(ConvertAddressToHuman(dto.getAddress()));
        consoleLogger.info("DTO с id = {} конвертирована в сущность", dto.getId());
        return human;
    }

    public HumanDto ConvertToDTO(Human human) {
        HumanDto dto = new HumanDto();
        dto.setId(human.getId());
        dto.setName(human.getName());
        dto.setBirthDate(human.getBirthDate());
        dto.setAddress(ConvertAddressToDTO(human.getAddress()));
        consoleLogger.info("Человек с id = {} конвертирован в dto", human.getId());
        return dto;
    }

    private Human.Address ConvertAddressToHuman(HumanDto.Address dtoAddress) {
        Human.Address address = new Human().new Address();
        address.setStreet(dtoAddress.getStreet());
        address.setCity(dtoAddress.getCity());
        return address;
    }

    private HumanDto.Address ConvertAddressToDTO(Human.Address address) {
        HumanDto.Address dtoAddress = new HumanDto().new Address();
        dtoAddress.setStreet(address.getStreet());
        dtoAddress.setCity(address.getCity());
        return dtoAddress;
    }
}
