package jsmg.cargocliente.domain;

import jsmg.cargocliente.dto.CustomerDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String last_name;

    @OneToMany(mappedBy = "customer")
    private List<Shipment> shipmentList;


    public Customer(CustomerDTO customerDTO){
        BeanUtils.copyProperties(customerDTO,this);
    }
}
