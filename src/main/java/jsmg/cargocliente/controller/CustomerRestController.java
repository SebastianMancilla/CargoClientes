package jsmg.cargocliente.controller;

import jsmg.cargocliente.domain.Customer;
import jsmg.cargocliente.dto.CustomerDTO;
import jsmg.cargocliente.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("Cliente")
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return  new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody CustomerDTO customersDTO){
        return new ResponseEntity<>(customerService.save(customersDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customer){
        CustomerDTO customerDTO = customerService.findById(id);
        customerService.logicUpdate(customerDTO,customer);
        return  new ResponseEntity<>(customerService.save(customerDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
