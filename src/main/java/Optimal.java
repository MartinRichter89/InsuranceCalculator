package main.java;

public class Optimal implements Product {

	private final static double price = 700.00;
	private final static String name = "Optimal";

	@Override
	public double calculate(double square) {
		/* change here calculation of sum for this product */
		double result = 0;
		result = square * price;
		return result;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}
}