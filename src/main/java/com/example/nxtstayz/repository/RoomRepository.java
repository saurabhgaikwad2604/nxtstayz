package com.example.nxtstayz.repository;

import com.example.nxtstayz.model.*;
import java.util.*;

public interface RoomRepository {
    ArrayList<Room> getRooms();

    Room getRoomById(int id);

    Room addRoom(Room room);

    Room updateRoom(int id, Room room);

    void deleteRoom(int id);

    Hotel getRoomHotel(int id);
}