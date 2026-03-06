package mil.army.moda.vehicle.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    private String make;
    private String model;
    private int year;
    private int milage;

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle(String make, String model, int year, int milage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.milage = milage;
    }

    public Vehicle(){
        this("Toyota", "Supra", 2001, 80000);
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMilage() {
        return milage;
    }
}
