package lopatin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HumanDTO {
    private int ID;
    private String name;
    private Address address;
    private Date birthDate;

    @Data
    static class Address {
        private String city;
        private String street;
    }
}
