package com.nagarro.javaasignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String model;
        String type;
        double price=0;
        String insuranceType;
        String yesNo; 
        boolean exit;
        do{
            System.out.println("Enter Car Model: ");
            model = sc.next();
            
            do {
            	System.out.println("Enter the car type: ");
            	type = sc.next();         
            }while(!Car.isCarTypeValid(type));
            
            do {
            	System.out.println("Enter the car cost price: ");            	
            	exit = true;
            	try{
            		price = sc.nextDouble();
            	}
            	catch(InputMismatchException e) {
            		System.out.println("Invalid price!");
            		exit = false;
            		sc.nextLine();
//            		e.printStackTrace();
            	}
            }while(!exit);
            
            do {
            	System.out.println("Enter the Insurance type: ");
            	insuranceType = sc.next();            	
            }while(!Car.isInsuranceTypeValid(insuranceType));
            
            Car car = new Car(model, type, price, insuranceType);
            InsuranceCalculator cal =new InsuranceCalculator(car);
            Double premium = cal.getInsurancePremium();
            System.out.println("------------");
            System.out.println("Car Model: "+model);
            System.out.println("Car Type: "+type);
            System.out.println("Car Price: "+price);
            System.out.println("Insurance Type: "+insuranceType);
            System.out.println("Insurance Amount: "+premium);
            System.out.println("--------------");
            System.out.println("Do you want to enter details of any other car (y/n)");
            yesNo=sc.next();
        }while(yesNo.equalsIgnoreCase("Y"));
        sc.close();
        System.out.println("---------------finished");
    }
}
