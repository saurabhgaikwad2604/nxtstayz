package com.example.nxtstayz.service;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class RoomJpaService implements RoomRepository {
    @Autowired
    private RoomJpaRepository roomJpaRepository;
    @Autowired
    private HotelJpaRepository hotelJpaRepository;

    @Override
    public ArrayList<Room> getRooms() {
        List<Room> roomList = roomJpaRepository.findAll();
        ArrayList<Room> rooms = new ArrayList<>(roomList);
        return rooms;
    }

    @Override
    public Room getRoomById(int id) {
        try {
            Room room = roomJpaRepository.findById(id).get();
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room addRoom(Room room) {
        try {
            Hotel hotel = room.getHotel();
            int hotelId = hotel.getId();
            Hotel newHotel = hotelJpaRepository.findById(hotelId).get();
            room.setHotel(newHotel);
            roomJpaRepository.save(room);
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room updateRoom(int id, Room room) {
        try {
            Room newRoom = roomJpaRepository.findById(id).get();
            if (room.getRoomNumber() != null) {
                newRoom.setRoomNumber(room.getRoomNumber());
            }
            if (room.getType() != null) {
                newRoom.setType(room.getType());
            }
            if (room.getPrice() != 0) {
                newRoom.setPrice(room.getPrice());
            }
            if (room.getHotel() != null) {
                Hotel hotel = room.getHotel();
                int hotelId = hotel.getId();
                Hotel newHotel = hotelJpaRepository.findById(hotelId).get();
                newRoom.setHotel(newHotel);
            }
            roomJpaRepository.save(newRoom);
            return newRoom;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRoom(int id) {
        try {
            roomJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Hotel getRoomHotel(int id) {
        try {
            Room room = roomJpaRepository.findById(id).get();
            Hotel hotel = room.getHotel();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
