package com.sample.HotelManagment.DTO;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomRequest {

	@NotBlank(message = "Room number is requered")
	private String roomNumber;
	
	@NotBlank(message = "Room Type is requered")
	private String roomType;

	@NotNull(message = "price is requered")
	private Double roomPrice;
	
	private String description;

	public boolean available;
	
	private MultipartFile imageUrl;


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setImageUrl(MultipartFile imageUrl) {
        this.imageUrl = imageUrl;
    }

	public String getImageUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
