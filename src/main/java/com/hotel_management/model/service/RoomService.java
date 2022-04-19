package com.hotel_management.model.service;

import com.hotel_management.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    void SaveRoomList(Room room);
    Room getRoomById(long roomid);
    void deleteRoom(long roomid);
}
