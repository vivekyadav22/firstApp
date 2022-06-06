package customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private int id;
    private String firstName, lastName, email;

}
