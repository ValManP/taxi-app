package edu.unn.taxi.impl.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int ID;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Location start;

    @ManyToOne
    private Location finish;

    @Column
    @Temporal(TemporalType.TIME)
    private Date timestamp;

    @Column
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getFinish() {
        return finish;
    }

    public void setFinish(Location finish) {
        this.finish = finish;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
