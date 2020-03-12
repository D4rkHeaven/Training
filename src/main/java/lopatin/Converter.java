package lopatin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Converter {
    private Logger consoleLogger = LoggerFactory.getLogger(Converter.class);
    private Human.Address ConvertAddressToHuman(HumanDTO.Address dtoAd) {
        Human.Address address = new Human().new Address();
        address.setStreet(dtoAd.getStreet());
        address.setCity(dtoAd.getCity());
        return address;
    }

    private HumanDTO.Address ConvertAddressToDTO(Human.Address ad) {
        HumanDTO.Address address = new HumanDTO().new Address();
        address.setStreet(ad.getStreet());
        address.setCity(ad.getCity());
        return address;
    }

    public Human ConvertToHuman(HumanDTO dto) {
        Human human = new Human();
        human.setID(dto.getID());
        human.setName(dto.getName());
        human.setBirthDate(dto.getBirthDate());
        human.setAddress(ConvertAddressToHuman(dto.getAddress()));
        consoleLogger.info("DTO с id = {} конвертирована в сущность", dto.getID());
        return human;
    }

    public HumanDTO ConvertToDTO(Human human) {
        HumanDTO dto = new HumanDTO();
        dto.setID(human.getID());
        dto.setName(human.getName());
        dto.setBirthDate(human.getBirthDate());
        dto.setAddress(ConvertAddressToDTO(human.getAddress()));
        consoleLogger.info("Человек с id = {} конвертирован в dto", human.getID());
        return dto;
    }
}
