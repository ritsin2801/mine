package com.nagarro.javaasignment;

public class InsuranceCalculator {
	private Car car;
	public InsuranceCalculator(Car car) {
		this.car = car;
    }
	public double getInsurancePremium() {
		double amount=0;
		String carType = car.getCarType().toUpperCase();
		switch(carType) {
		case "SUV":
			amount = 0.1*car.getCarPrice();
			break;
		case "HATCHBACK":
			amount = 0.05*car.getCarPrice();
			break;
		case "SEDAN":
			amount = 0.08*car.getCarPrice();
			break;
		}
		if(car.getInsuranceType().equalsIgnoreCase("amount")) {
			double increase = 0.2*amount;
			amount += increase;
		}
		return amount;
	}
}


