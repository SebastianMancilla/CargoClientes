package jsmg.cargocliente.controller;

import jsmg.cargocliente.domain.Shipment;
import jsmg.cargocliente.dto.ShipmentDTO;
import jsmg.cargocliente.service.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("Shipment")
@RequestMapping(path = "/shipment")
@AllArgsConstructor
public class ShipmentRestController {
    private final ShipmentService shipmentService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Shipment>> findAllShipments(){
        return new ResponseEntity<>(shipmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ShipmentDTO> findShipmentById(@PathVariable Long id){
        return  new ResponseEntity<>(shipmentService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Shipment> createNewShipment(@RequestBody ShipmentDTO shipmentDTO){
        return  new ResponseEntity<>(shipmentService.save(shipmentDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Shipment> updateShipment(@RequestBody ShipmentDTO shipmentDTO, @PathVariable Long id){
        ShipmentDTO shipment = shipmentService.findById(id);
        shipmentService.logicUpdate(shipment, shipmentDTO);
        return  new ResponseEntity<>(shipmentService.save(shipment), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Shipment> deleteShipment(@PathVariable Long id){
        shipmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
