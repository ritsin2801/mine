package com.nagarro.inputoutput;

import java.util.*;

import com.nagarro.model.TShirt;
import com.nagarro.comparator.Compare;
import com.nagarro.dao.TshirtDaoImp;
import com.nagarro.exception.InputValidation;
import com.nagarro.exception.InvalidInputException;
import com.nagarro.watcher.*;

public class InputOutput {

	private String color;
	private String size;
	private String gender;
	private int outputPrefer;
	public Scanner scan = new Scanner(System.in);

//	public InputOutput() throws FileNotFoundException {
//		dataEntry();
//	}

	public void input() throws InvalidInputException {
		// TODO Auto-generated method stub

		System.out.print("Enter Color: ");
		color = scan.next().toLowerCase();
		System.out.print("Enter Size (S/M/L/XL/XXL): ");
		size = scan.next().toLowerCase();
		System.out.print("Enter Gender (M/F/U): ");
		gender = scan.next().toLowerCase();
		System.out.print("Enter Output Preference (1-Sort by Price | 2-Sort by Rating ): ");
		outputPrefer = scan.nextInt();

		InputValidation exception = new InputValidation();

		exception.isInputValid(size, gender, outputPrefer);

	}

	public void output() {
		// TODO Auto-generated method stub

		List<TShirt> output = new ArrayList<TShirt>();

		TshirtDaoImp dao = new TshirtDaoImp();
		output = dao.getSessionWithoutTransaction(color, size, gender);
//		dao.closeSession();

		if (output.size() == 0) {
			System.err.println("T-Shirts of Given Preferences are not available");
		} else {
			Compare compare = new Compare();
			compare.sortingPreference(output, outputPrefer);
			System.out.println("Name\t\t\t\t\t\t\t\tPrice\t\t\tRating");
			for (TShirt tshirt : output) {
				
				if(tshirt.getName().length() >= 30)
				{
					System.out
					.println(tshirt.getName() + "\t\t\t " + tshirt.getPrice() + " \t\t " + tshirt.getRating());
				}
				else if (tshirt.getName().length() >= 20) {
					System.out
					.println(tshirt.getName() + "\t\t\t\t\t " + tshirt.getPrice() + " \t\t " + tshirt.getRating());
				} else {
					System.out
							.println(tshirt.getName() + "\t\t\t\t\t\t " + tshirt.getPrice() + " \t\t " + tshirt.getRating());
				}
			}

			System.out.println();
		}
	}
}
