package mil.army.moda.vehicle.vehicle;

import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository){
        this.repository = repository;
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        return this.repository.save(vehicle);
    }

    public Vehicle getVehicle(Long id){
        return repository.getReferenceById(id);
    }
}
