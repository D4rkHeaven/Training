package lopatin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String fio;
    private Role role;
    enum Role{
        ADMIN,
        USER,
        MODERATOR
    }
    public void greeting(User user){
        System.out.println("Приветствуем " +user.getFio() + " с ролью " + user.getRole());
    }
}
