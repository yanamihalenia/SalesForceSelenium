package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

    private String firstName;
    private String lastName;
    private String accountName;
    private String description;
    private String phone;
}
