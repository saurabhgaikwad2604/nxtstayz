package com.example.nxtstayz.controller;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RoomController {
	@Autowired
	public RoomJpaService roomService;

	@GetMapping("/hotels/rooms")
	public ArrayList<Room> getRooms() {
		return roomService.getRooms();
	}

	@GetMapping("/hotels/rooms/{roomId}")
	public Room getRoomById(@PathVariable("roomId") int id) {
		return roomService.getRoomById(id);
	}

	@PostMapping("/hotels/rooms")
	public Room addRoom(@RequestBody Room room) {
		return roomService.addRoom(room);
	}

	@PutMapping("/hotels/rooms/{roomId}")
	public Room updateRoom(@PathVariable("roomId") int id, @RequestBody Room room) {
		return roomService.updateRoom(id, room);
	}

	@DeleteMapping("/hotels/rooms/{roomId}")
	public void deleteRoom(@PathVariable("roomId") int id) {
		roomService.deleteRoom(id);

	}

	@GetMapping("/rooms/{roomId}/hotel")
	public Hotel getRoomHotel(@PathVariable("roomId") int id) {
		return roomService.getRoomHotel(id);
	}

}