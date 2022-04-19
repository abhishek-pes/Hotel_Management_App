package com.hotel_management.model;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long driverid;

    @Column(name = "driver_name")
    private String Drivername;

    @Column(name = "experience")
    private String DriverExp;

    @Column(name = "status")
    private  String status;

    @Column(name = "assignedto")
    private String assigedto;

    public long getDriverid() {
        return driverid;
    }

    public void setDriverid(long driverid) {
        this.driverid = driverid;
    }

    public String getDrivername() {
        return Drivername;
    }

    public void setDrivername(String drivername) {
        Drivername = drivername;
    }

    public String getDriverExp() {
        return DriverExp;
    }

    public void setDriverExp(String driverExp) {
        DriverExp = driverExp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssigedto() {
        return assigedto;
    }

    public void setAssigedto(String assigedto) {
        this.assigedto = assigedto;
    }
}
