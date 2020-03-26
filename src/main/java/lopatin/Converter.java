package lopatin;

/**
 * Converts human to dto and vice versa
 */
public class Converter {

    public Human ConvertToHuman(HumanDto dto) {
        Human human = new Human();
        human.setId(dto.getId());
        human.setName(dto.getName());
        human.setBirthDate(dto.getBirthDate());
        human.setAddress(ConvertAddressToHuman(dto.getAddress()));
        return human;
    }

    public HumanDto ConvertToDto(Human human) {
        HumanDto dto = new HumanDto();
        dto.setId(human.getId());
        dto.setName(human.getName());
        dto.setBirthDate(human.getBirthDate());
        dto.setAddress(ConvertAddressToDto(human.getAddress()));
        return dto;
    }

    private Human.Address ConvertAddressToHuman(HumanDto.Address dtoAddress) {
        Human.Address address = new Human().new Address();
        address.setStreet(dtoAddress.getStreet());
        address.setCity(dtoAddress.getCity());
        return address;
    }

    private HumanDto.Address ConvertAddressToDto(Human.Address address) {
        HumanDto.Address dtoAddress = new HumanDto().new Address();
        dtoAddress.setStreet(address.getStreet());
        dtoAddress.setCity(address.getCity());
        return dtoAddress;
    }
}
