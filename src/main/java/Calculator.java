package main.java;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program is calculating the sum insured for an apartment.
 *
 * @author Martin Richter
 * @version 1.0
 * @since 2018-09-13
 */

public class Calculator {
	/* add new products here */
	static Product compact = new Compact();
	static Product optimal = new Optimal();
	static double sumInsured = 0;
	static double squareMeters = 0;
	static int productId = 0;

	public static void main(String[] args) {
		/* calling the functions and dealing with exceptions */
		try {
			doInput();
		} catch (InputMismatchException ime) {
			System.out.println("Your input is wrong, it just doesn't make sense "
					+ "or you used a point instead of a comma for decimal places!");
			ime.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("An undefined exception occurred!");
			e.printStackTrace();
			System.exit(0);
		}

		try {
			DecimalFormat f = new DecimalFormat("#0.00");
			sumInsured = calculate(squareMeters, productId);
			System.out.println("Your apartment has a sum insured of " + f.format(sumInsured) + "€.");
		} catch (Exception e) {
			System.out.println("Something went wrong with the long and difficult calculation of the sum insured!");
			e.printStackTrace();
			System.exit(0);
		}
	}

	/* function for entering the needed parameter */
	public static void doInput() {
		Scanner input = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("#0.00");

		System.out.println("How many square meters does your apartment have?");
		squareMeters = input.nextDouble();
		if (squareMeters <= 0) {
			input.close();
			throw new InputMismatchException();
		}

		/* add new products here */
		System.out.println("Which insurance product do you want to calculate?");
		System.out.println("1 - " + compact.getName() + "(" + f.format(compact.getPrice()) + "€ per m²)");
		System.out.println("2 - " + optimal.getName() + "(" + f.format(optimal.getPrice()) + "€ per m²)");
		productId = input.nextInt();
		if (productId < 1 || productId > 2) {
			input.close();
			throw new InputMismatchException();
		}

		input.close();
	}

	/* function for calling the calculation */
	public static double calculate(double square, int product) {
		double result = 0;
		/* add new products here */
		switch (product) {
		case 1:
			result = compact.calculate(square);
			break;
		case 2:
			result = optimal.calculate(square);
			break;
		}
		return result;
	}
}