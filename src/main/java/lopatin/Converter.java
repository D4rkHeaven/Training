package lopatin;

public interface Converter<T> {
    static Human.Address ConvertAddressToHuman(HumanDTO.Address dtoAd) {
        Human.Address address = new Human.Address();
        address.setStreet(dtoAd.getStreet());
        address.setCity(dtoAd.getCity());
        return address;
    }

    static HumanDTO.Address ConvertAddressToDTO(Human.Address ad) {
        HumanDTO.Address address = new HumanDTO.Address();
        address.setStreet(ad.getStreet());
        address.setCity(ad.getCity());
        return address;
    }

    static Human ConvertToHuman(HumanDTO dto) {
        Human human = new Human();
        human.setID(dto.getID());
        human.setName(dto.getName());
        human.setBirthDate(dto.getBirthDate());
        human.setAddress(ConvertAddressToHuman(dto.getAddress()));
        return human;
    }

    static HumanDTO ConvertToDTO(Human human) {
        HumanDTO dto = new HumanDTO();
        dto.setID(human.getID());
        dto.setName(human.getName());
        dto.setBirthDate(human.getBirthDate());
        dto.setAddress(ConvertAddressToDTO(human.getAddress()));
        return dto;
    }
}
