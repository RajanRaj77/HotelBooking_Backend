package com.sample.HotelManagment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sample.HotelManagment.DTO.RoomRequest;
import com.sample.HotelManagment.entity.Room;

public interface RoomService {

	Room addRoom(RoomRequest request, MultipartFile imageUrl);
	
	Room updateRoom(Long id, RoomRequest request, MultipartFile imageUrl);
	
	void deleteRoom(Long id);
	
	Room getRoomById(Long id);
	
	List<Room> getAllRooms();
	
	List<Room> getAvailableRooms();
	
}
