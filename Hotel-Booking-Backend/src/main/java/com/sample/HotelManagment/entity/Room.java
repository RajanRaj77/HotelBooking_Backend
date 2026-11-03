package com.sample.HotelManagment.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String roomNumber;
	
	@Column(nullable = false)
	private String roomType;
	
	@Column(nullable = false)
	private Double roomPrice;
	
	private String description;
	
	// Local file path inside the AWS s3 url
	
	public String getDescription() {
		return description;
	}
	private String imageUrl;
	
	private boolean available = true;
	
	@OneToMany(mappedBy = "room")
	private List<Booking> bookings;

	public Room() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}


	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setDescription(String description) {
	    this.description = description;
	}
	
	
}
