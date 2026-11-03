package com.sample.HotelManagment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.HotelManagment.DTO.RoomRequest;
import com.sample.HotelManagment.entity.Room;
import com.sample.HotelManagment.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Room> addRoom(
            @ModelAttribute RoomRequest request,
            @RequestPart(value = "image", required = false) 
            MultipartFile image) {

        Room room = roomService.addRoom(request, image);

        return ResponseEntity.ok(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable Long id,
            @ModelAttribute RoomRequest request,
            @RequestPart(value = "image", required = false) MultipartFile image) {

        Room room = roomService.updateRoom(id, request, image);

        return ResponseEntity.ok(room);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {

        roomService.deleteRoom(id);

        return ResponseEntity.ok("Room deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {

        Room room = roomService.getRoomById(id);

        return ResponseEntity.ok(room);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {

        List<Room> rooms = roomService.getAllRooms();

        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {

        List<Room> rooms = roomService.getAvailableRooms();

        return ResponseEntity.ok(rooms);
    }
}