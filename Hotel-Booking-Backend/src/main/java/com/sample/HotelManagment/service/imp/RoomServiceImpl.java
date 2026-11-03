package com.sample.HotelManagment.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sample.HotelManagment.DTO.RoomRequest;
import com.sample.HotelManagment.entity.Room;
import com.sample.HotelManagment.repository.RoomRepository;
import com.sample.HotelManagment.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService{
	
	private final RoomRepository roomRepository;
	private final FileStorageServiceImpl fileStorageServiceImpl;
	
	public RoomServiceImpl(RoomRepository roomRepository,
			FileStorageServiceImpl fileStorageServiceImpl) {
		this.roomRepository = roomRepository;
		this.fileStorageServiceImpl = fileStorageServiceImpl;
	}

	@Override
	public Room addRoom(RoomRequest request, MultipartFile image) {
		
		Room room = new Room();
		room.setRoomNumber(request.getRoomNumber());
		room.setRoomType(request.getRoomType());
		room.setRoomPrice(request.getRoomPrice());
		room.setAvailable(request.isAvailable());
		room.setDescription(request.getDescription());
		
		if(image != null && !image.isEmpty()) {
			String imageName = fileStorageServiceImpl.saveFile(image);
			room.setImageUrl(imageName);
		}
		return roomRepository.save(room);
	}

	@Override
	public Room updateRoom(Long id, RoomRequest request, MultipartFile image) {
		
		Room existingRoom = roomRepository.findById(id)
								.orElseThrow(() -> new RuntimeException("Room is not Avalibale at this ID" + id));
		
		// Update the room Details
		existingRoom.setRoomNumber(request.getRoomNumber());
		existingRoom.setRoomType(request.getRoomType());
		existingRoom.setRoomPrice(request.getRoomPrice());
		existingRoom.setAvailable(request.isAvailable());
		existingRoom.setDescription(request.getDescription());
		
		// Update the image was new image is provided
		if(image != null && !image.isEmpty()) {
			
			// Delete the old image
			if(existingRoom.getImageUrl() != null && !existingRoom.getImageUrl().isBlank()) {
				
				fileStorageServiceImpl.deleteFile((request).getImageUrl());
				
			}
			
			//Save new Image
			
			String newImageName = fileStorageServiceImpl.saveFile(image);
			
			existingRoom.setImageUrl(newImageName);
		}
				
		return roomRepository.save(existingRoom);
	}

	@Override
	public void deleteRoom(Long id) {
		Room room = roomRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("The Room is not avaliable at the id " + id));
		
		// delete image by uploaded folder
		if(room.getImageUrl() != null && !room.getImageUrl().isBlank()) {
			fileStorageServiceImpl.deleteFile(room.getImageUrl());
		}
		
		roomRepository.delete(room);
	}

	@Override
	public Room getRoomById(Long id) {
		return roomRepository.findById(id) 
					.orElseThrow(() -> new RuntimeException("The Room is not Available with the id" + id));
	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public List<Room> getAvailableRooms() {
		return roomRepository.findByAvailableTrue();
	}

}
