package hw6.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
public class UserTable {
    @Setter
    private String number;

    @Setter
    private String user;

    @Setter
    private String description;

    public UserTable(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }
}
