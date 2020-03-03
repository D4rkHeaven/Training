package lopatin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Service<T extends HumanDTO> {
    /* Костыль для генерации случайных строк */
    static String stringGen() {
        String string = "randomletters";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 8 + 2);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }

    // Генерация одного человека
    static HumanDTO get(HumanDTO dto) {
        HumanDTO.Address address = new HumanDTO.Address();
        dto.setID((int) (Math.random() * 10));
        dto.setName(stringGen());
        dto.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        dto.setAddress(address);
        return dto;
    }

    // Генерация i-го количества людей
    static List<HumanDTO> getAll(int i) {
        ArrayList<HumanDTO> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDTO dto = new HumanDTO();
            list.add(Service.get(dto));
        }
        return list;
    }

    // Вывод инфы об одном dto
    static void save(HumanDTO dto) {
        System.out.println(dto);
    }

    // Вывод инфы о всех dto
    static void saveAll(List<HumanDTO> dtos) {
        for (HumanDTO go : dtos) {
            System.out.println(go);
        }
    }
}
