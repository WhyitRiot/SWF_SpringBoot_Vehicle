package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehicleRepositoryTest {
    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    void shouldSaveAVehicle() {

        //Arrange
        Vehicle doghouse = new Vehicle("Sopwith", "dog-1", 1975, 0);
        System.out.println("ID: " + doghouse.getId());
        //Act
        Vehicle savedVehicle = vehicleRepository.save(doghouse);
        Optional<Vehicle> retrievedVehicle = vehicleRepository.findById(doghouse.getId());

        //Assert
        assertThat(retrievedVehicle.get().getMake()).isEqualTo("Sopwith");
        assertEquals("dog-1", retrievedVehicle.get().getModel());
        assertEquals(1975, retrievedVehicle.get().getVecYear());
        assertEquals(0, retrievedVehicle.get().getMilage());
        assertThat(retrievedVehicle.get()).isEqualTo(doghouse);
    }

    @Test
    void shouldSaveMoreThanOneVehicle() {
        //Arrange
        Vehicle doghouse = new Vehicle("Sopwith", "dog-1", 1975, 0);
        Vehicle supra = new Vehicle("Toyota", "Supra", 2001, 90000);

        //Act
        vehicleRepository.save(doghouse);
        vehicleRepository.save(supra);
        Optional<Vehicle> retrievedDoghouse = vehicleRepository.findById(doghouse.getId());
        Optional<Vehicle> retrievedSupra = vehicleRepository.findById(supra.getId());

        //Assert
        assertEquals(1, retrievedDoghouse.get().getId());
        assertEquals(2, retrievedSupra.get().getId());

    }

}