package lopatin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверка сервиса");
        Service service = new Service();
        HumanDTO dto = new HumanDTO();
        service.get(dto);
        service.save(dto);
        List<HumanDTO> humanDTOS = service.getAll(3);
        service.saveAll(humanDTOS);
    }
}
