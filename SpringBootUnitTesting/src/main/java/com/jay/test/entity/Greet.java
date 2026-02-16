package com.jay.test.entity;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greet {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String message;
	
	private String occasion;

	public Greet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Greet( String message, String occasion) {
		super();
		this.message = message;
		this.occasion = occasion;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	@Override
	public String toString() {
		return "Greet [id=" + id + ", message=" + message + ", occasion=" + occasion + "]";
	}
	
	
	
}
