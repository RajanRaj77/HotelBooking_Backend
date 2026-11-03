package com.sample.HotelManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.HotelManagment.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	
	// get available room
	List<Room> findByAvailableTrue();
	
	//Search rooom by type
	List<Room> findByRoomType(String roomType);
	
	// check room number already exists
	boolean existsByRoomNumber(String roomNumber);

}
