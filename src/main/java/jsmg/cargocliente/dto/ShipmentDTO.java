package jsmg.cargocliente.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jsmg.cargocliente.domain.Customer;
import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDTO {
    public Long id;

    public String name;
    public String description;
    public Customer customer;

    @JsonProperty("customer")
    private void unpackNested(Long customerId){
        this.customer = new Customer();
        customer.setId(customerId);
    }
}
