package com.hotel_management.model.service;

import com.hotel_management.model.Room;
import com.hotel_management.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceIMPL implements RoomService {
    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void SaveRoomList(Room room) {
        this.roomRepository.save(room);
    }

    @Override
    public Room getRoomById(long roomid) {
        Optional<Room> optional = roomRepository.findById(roomid);
        Room room = null;
        if(optional.isPresent())
        {
            room = optional.get();
        }
        else{
            throw new RuntimeException("Room not found for id: "+roomid);
        }
        return room;    }

    @Override
    public void deleteRoom(long roomid) {
        this.roomRepository.deleteById(roomid);
    }
}
