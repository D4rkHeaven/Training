package lopatin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверка сервиса");
        Service service = new Service();
        HumanDto dto = new HumanDto();
        service.get(dto);
        service.save(dto);
        List<HumanDto> humanDtoList = service.getAll(3);
        service.saveAll(humanDtoList);
    }
}
