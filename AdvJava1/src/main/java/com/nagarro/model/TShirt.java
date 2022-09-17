package com.nagarro.model;

public class TShirt {

	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private float price;
	private float rating;
	private String availability;
    
    
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getSize() {
		return size;
	}
	
	public float getPrice() {
		return price;
	}
	
	public float getRating() {
		return rating;
	}
	
	public String getAvailability() {
		return availability;
	}
	
//	SETTERS
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public void setAvailability(String availability) {
		this.availability = availability;
	}
    
    
	
}
