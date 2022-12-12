package jsmg.cargocliente.dto;

import jsmg.cargocliente.domain.Shipment;
import lombok.*;

import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    public Long id;
    public String name;
    public String last_name;

    public List<Shipment> shipments;
}
