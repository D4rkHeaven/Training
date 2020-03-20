package lopatin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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
        private int flat;

        public int compareTo(Address address) {
            int diff = city.compareTo(address.city);
            if (diff == 0) {
                diff = street.compareTo(address.street);
                if (diff == 0) {
                    diff = house - address.house;
                    if (diff == 0) {
                        return flat - address.flat;
                    }
                    return diff;
                }
                return diff;
            }
            return diff;
        }
    }
}
