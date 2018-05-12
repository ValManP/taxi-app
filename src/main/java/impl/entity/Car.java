package impl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    private String model;
    private String color;

    @Id
    private String number;

    public Car(String model, String color, String number) {
        this.model = model;
        this.color = color;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }
}
