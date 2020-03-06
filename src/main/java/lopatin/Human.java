package lopatin;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Human {
    private String fio;
    private int age;
    private Address address;
    @AllArgsConstructor
    @Data
    class Address {
        private String city;
        private String street;
        private int house;
        private int room;
    }
}
