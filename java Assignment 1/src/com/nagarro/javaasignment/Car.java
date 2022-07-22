package com.nagarro.javaasignment;

public class Car {
    private String model;
    private String type;
    private double price;
    private String insuranceType;
    
    public Car(String model,String type,double price,String insuranceType){
        this.model = model;
        this.type = type;
        this.price = price;
        this.insuranceType = insuranceType;
    }
    
    public static boolean isCarTypeValid(String type) {
    	boolean isValid;
    	type = type.toUpperCase();
    	switch(type) {
    	case "SUV":
    	case "SEDAN":
    	case "HATCHBACK":
    		isValid = true;
    		break;
    	default:
    		System.out.println("Invalid car type. Pls enter valid car type");
    		isValid = false;
    	}
    	return isValid;
    }
    
    public static boolean isInsuranceTypeValid(String type) {
    	boolean isValid;
    	type = type.toUpperCase();
    	switch(type) {
    	case "BASIC":
    	case "PREMIUM":
    		isValid = true;
    		break;
    	default:
    		System.out.println("Invalid insurance type. Pls enter valid insurance type");
    		isValid = false;
    	}
    	return isValid;
    }
    public String getCarmodel() {
        return model;
    }

    public void setCarModel(String model) {
        this.model = model;
    }

    public String getCarType() {
        return type;
    }

    public void setCarType(String type) {
        this.type = type;
    }

    public double getCarPrice() {
        return price;
    }

    public void setCarPrice(double price) {
        this.price = price;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}



