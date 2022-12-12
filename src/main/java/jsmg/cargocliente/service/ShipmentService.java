package jsmg.cargocliente.service;

import jsmg.cargocliente.domain.Shipment;
import jsmg.cargocliente.dto.ShipmentDTO;
import jsmg.cargocliente.exeptions.*;
import jsmg.cargocliente.repository.ShipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    public List<Shipment> findAll(){
        List<Shipment> shipments = shipmentRepository.findAll();
        if(shipments.isEmpty()){
            throw new NoContentExep("No hay Cargos Registrados");
        }

        return  shipments;
    }

    public ShipmentDTO findById(Long id){
        Optional<Shipment> shipment = shipmentRepository.findById(id);
        if(shipment.isEmpty()){
            throw  new BadRequestExep("Id No existente en la base de datos");
        }

        ShipmentDTO shipmentsDTO = new ShipmentDTO();
        shipmentsDTO.setId(shipment.get().getId());
        shipmentsDTO.setName(shipmentsDTO.getName());
        shipmentsDTO.setDescription(shipment.get().getDescription());
//        shipmentsDTO.setCustomers(shipment.get().getCustomers());

        return shipmentsDTO;
    }

    public Shipment save(ShipmentDTO shipmentsDTO){
        if(shipmentsDTO.name.isEmpty()){
            throw  new BadRequestExep("El atributo 'name' es requerido");
        }
        if(shipmentsDTO.description.isEmpty()){
            throw new BadRequestExep("El atributo 'description' es requerido");
        }

        return  shipmentRepository.save(new Shipment(shipmentsDTO));
    }

    public void logicUpdate(ShipmentDTO shipmentDTO, ShipmentDTO dto){
        shipmentDTO.setId(dto.getId());
        shipmentDTO.setName(dto.getName());
        shipmentDTO.setDescription(shipmentDTO.getDescription());
    }

    public void delete(Long id){
        Optional<Shipment> shipment = shipmentRepository.findById(id);
        if(shipment.isEmpty()){
            throw  new NoContentExep("El id No existe en la base de datos");
        }
        shipmentRepository.deleteById(id);
    }
}
