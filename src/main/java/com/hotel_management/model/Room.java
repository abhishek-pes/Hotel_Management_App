package com.hotel_management.model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomid;

    @Column(name = "roomstatus")
    private String roomstatus;

    @Column(name = "no_of_beds")
    private Integer noOfBeds;

    @Column(name = "price")
    private Float price;

    @Column(name = "assignedto")
    private String assignedto;

    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public String getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(String roomstatus) {
        this.roomstatus = roomstatus;
    }

    public Integer getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(Integer noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(String assignedto) {
        this.assignedto = assignedto;
    }
}
