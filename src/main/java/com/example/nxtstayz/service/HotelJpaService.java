package com.example.nxtstayz.service;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class HotelJpaService implements HotelRepository {
    @Autowired
    private HotelJpaRepository hotelJpaRepository;
    @Autowired
    private RoomJpaRepository roomJpaRepository;

    @Override
    public ArrayList<Hotel> getHotels() {
        List<Hotel> hotelList = hotelJpaRepository.findAll();
        ArrayList<Hotel> hotels = new ArrayList<>(hotelList);
        return hotels;
    }

    @Override
    public Hotel getHotelById(int id) {
        try {
            Hotel hotel = hotelJpaRepository.findById(id).get();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        hotelJpaRepository.save(hotel);
        return hotel;
    }

    @Override
    public Hotel updateHotel(int id, Hotel hotel) {
        try {
            Hotel newHotel = hotelJpaRepository.findById(id).get();
            if (hotel.getName() != null) {
                newHotel.setName(hotel.getName());
            }
            if (hotel.getLocation() != null) {
                newHotel.setLocation(hotel.getLocation());
            }
            if (hotel.getRating() != 0) {
                newHotel.setRating(hotel.getRating());
            }
            return hotelJpaRepository.save(newHotel);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteHotel(int id) {
        try {
            Hotel hotel = hotelJpaRepository.findById(id).get();
            List<Room> rooms = roomJpaRepository.findByHotel(hotel);
            for (Room room : rooms) {
                room.setHotel(null);
            }
            roomJpaRepository.saveAll(rooms);
            hotelJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Room> getHotelRooms(int id) {
        try {
            Hotel hotel = hotelJpaRepository.findById(id).get();
            List<Room> rooms = roomJpaRepository.findByHotel(hotel);
            return rooms;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}