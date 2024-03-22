package com.example.nxtstayz.repository;

import com.example.nxtstayz.model.*;
import java.util.*;

public interface HotelRepository{
    ArrayList<Hotel> getHotels();
    Hotel getHotelById(int id);
    Hotel addHotel(Hotel hotel);
    Hotel updateHotel(int id, Hotel hotel);
    void deleteHotel(int id);
    List<Room> getHotelRooms(int id);
}