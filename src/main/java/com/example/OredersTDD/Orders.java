package com.example.OredersTDD;


import org.hibernate.annotations.Entity;

@Entity
public class Orders {
    private String type;
    private String status;
    private String carId;

    public Orders(String type,String status,String carId) {
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
