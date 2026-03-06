package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class VehicleServiceTest {

    @Mock
    VehicleRepository repository;

    @InjectMocks
    VehicleService vehicleService;

    @Test
    void shouldGetBook(){
        Vehicle doghouse = new Vehicle("Sopwith", "dog-1", 1975, 0);
        doghouse.setId(1L);
        when(repository.save(doghouse)).thenReturn(doghouse);
        when(repository.getReferenceById(doghouse.getId())).thenReturn(doghouse);
        Vehicle savedVehicle = repository.save(doghouse);

        Vehicle retrievedVehicle = vehicleService.getVehicle(savedVehicle.getId());

        assertThat(retrievedVehicle.getMake()).isEqualTo(savedVehicle.getMake());
        verify(repository).save(doghouse);
    }
}