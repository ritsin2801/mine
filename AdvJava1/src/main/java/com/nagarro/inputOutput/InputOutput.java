package com.nagarro.inputOutput;

import java.util.*;

import com.nagarro.model.TShirt;
import com.nagarro.comparator.Compare;
import com.nagarro.exception.InputValidation;
import com.nagarro.exception.InvalidInputException;
import com.nagarro.watcher.*;

public class InputOutput {

	private String gender;
	private String size;
	private String color;
	private int outputPrefer;
	public Scanner scan = new Scanner(System.in);

//	public InputOutput() throws FileNotFoundException {
//		dataEntry();
//	}

	public void Productinput() throws InvalidInputException {
		// TODO Auto-generated method stub

		System.out.println("Enter Gender (M/F/U)-- ");
		gender = scan.next().toLowerCase();
		System.out.println("Enter Size (S/M/L/XL/XXL)-- ");
		size = scan.next().toLowerCase();
		System.out.println("Enter Color-- ");
		color = scan.next().toLowerCase();
		System.out.println("Enter Output Preference (1-Sort by Price | 2-Sort by Rating )-- ");
		outputPrefer = scan.nextInt();
		
		InputValidation exception = new InputValidation();
		
		exception.isInputValid(size,gender,outputPrefer);

	}

	public void Productoutput() {
		// TODO Auto-generated method stub

		List<TShirt> output = new ArrayList<TShirt>();

//		System.out.println(color+" : "+size+" : "+gender);
		
		for (String key : Watcher.tShirtCollection.keySet()) {
			List<TShirt> value = Watcher.tShirtCollection.get(key);
			for (int j = 0; j < value.size(); j++) {
				if (color.equalsIgnoreCase(value.get(j).getColor()) && size.equalsIgnoreCase(value.get(j).getSize())
						&& gender.equalsIgnoreCase(value.get(j).getGender()) && value.get(j).getAvailability().equalsIgnoreCase("y")) {

					output.add(value.get(j));
					}
			}
		}
		
		if(output.size()==0)
		{
			System.err.println("T-Shirts of Given Preferences are not available");
		}
		else
		{
			Compare compare = new Compare();
			compare.sortingPriority(output, outputPrefer);
	
			for (TShirt tshirt : output) {
				System.out.println("Name: " + tshirt.getName() + " Price: " + tshirt.getPrice() + " Rating: " + tshirt.getRating());
			}
	
			System.out.println();
		}
	}
}
