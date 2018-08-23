package com.example.OredersTDD;



import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
public class Orders {
    private String type;
    private String status;
    private String carId;

    public Orders() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();

    public Orders(String type, String status, String carId) {
        this.type=type;
        this.status=status;
        this.carId=carId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
