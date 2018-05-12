package impl.entity;

import javax.persistence.*;

@Entity(name = "drivers")
public class Driver extends User {
    @OneToOne
    private Car car;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Location location;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
