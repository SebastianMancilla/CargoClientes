package jsmg.cargocliente.domain;

import jsmg.cargocliente.dto.ShipmentDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "shipment")
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;


    @Getter(AccessLevel.PACKAGE)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Shipment(ShipmentDTO shipmentDTO){
        BeanUtils.copyProperties(shipmentDTO, this);
    }
}
