package jsmg.cargocliente.service;

import jsmg.cargocliente.domain.Customer;
import jsmg.cargocliente.dto.CustomerDTO;
import jsmg.cargocliente.exeptions.BadRequestExep;
import jsmg.cargocliente.exeptions.NoContentExep;
import jsmg.cargocliente.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll(){
        List<Customer> customer = customerRepository.findAll();

        if(customer.isEmpty()) {
            throw new NoContentExep("No hay Contenido");
        }

        return  customer;
    }

    public CustomerDTO findById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            throw  new BadRequestExep("Id no existe en la base de datos");
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.get().getId());
        customerDTO.setName(customer.get().getName());
        customerDTO.setLast_name(customer.get().getLast_name());
        customerDTO.setShipments(customer.get().getShipmentList());

        return customerDTO;

    }

    public Customer save(CustomerDTO customerDTO){
        if(customerDTO.name.isEmpty()){
            throw new BadRequestExep("El Atributo 'name' es requerido");
        }
        if(customerDTO.last_name.isEmpty()){
            throw new BadRequestExep("El Atributo 'last_name' es requerido");
        }

        return customerRepository.save( new Customer(customerDTO));
    }



    public void logicUpdate(CustomerDTO customer, CustomerDTO dto){
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setLast_name(dto.getLast_name());

    }

    public void delete(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            throw  new NoContentExep("No se encuentra el ID");
        }
        customerRepository.deleteById(id);
    }
}
