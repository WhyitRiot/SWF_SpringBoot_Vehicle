package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;


import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(VehicleController.class)
class VehicleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    VehicleService service;

    @Test
    void shouldSaveVehicle() throws Exception {
        //Arrange
        Vehicle supra = new Vehicle("Toyota", "Supra", 2001, 90000);
        when(service.saveVehicle(any(Vehicle.class))).thenReturn(supra);

        //Act
        mockMvc.perform(post("/api/vehicle/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(supra)))
                .andExpect(status().isCreated())
                .andDo(print());

        //Vehicle savedVehicle = service.saveVehicle(supra);

        //Assert
        //assertEquals(supra.getMake(), savedVehicle.getMake());
        verify(service, times(1)).saveVehicle(any(Vehicle.class));
    }

    @Test
    void shouldGetVehicle() throws Exception {
        //Arrange
        Vehicle supra = new Vehicle("Toyota", "Supra", 2001, 90000);
        supra.setId(1L);
        when(service.getVehicle(1L)).thenReturn(supra);

        //Act
        mockMvc.perform(get("/api/vehicle/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        verify(service, times(1)).getVehicle(any(Long.class));
    }
}