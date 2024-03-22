package com.example.nxtstayz.controller;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class HotelController {
	@Autowired
	public HotelJpaService hotelService;

	@GetMapping("/hotels")
	public ArrayList<Hotel> getHotels() {
		return hotelService.getHotels();
	}

	@GetMapping("/hotels/{hotelId}")
	public Hotel getHotelById(@PathVariable("hotelId") int id) {
		return hotelService.getHotelById(id);
	}

	@PostMapping("/hotels")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return hotelService.addHotel(hotel);
	}

	@PutMapping("/hotels/{hotelId}")
	public Hotel updateHotel(@PathVariable("hotelId") int id, @RequestBody Hotel hotel) {
		return hotelService.updateHotel(id, hotel);
	}

	@DeleteMapping("/hotels/{hotelId}")
	public void deleteHotel(@PathVariable("hotelId") int id) {
		hotelService.deleteHotel(id);
	}

	@GetMapping("/hotels/{hotelId}/rooms")
	public List<Room> getHotelRooms(@PathVariable("hotelId") int id) {
		return hotelService.getHotelRooms(id);
	}
}
