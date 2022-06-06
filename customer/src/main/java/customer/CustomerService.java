package customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRegistrationRequest request) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();
    }
}
