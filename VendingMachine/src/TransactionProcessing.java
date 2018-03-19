
/** Project: Milestone 4
 * Summary: Source code for Transaction Processing
 * Class: CST-135
 * Date: March 7, 2018
 * Author: Tim James
 */

import java.util.ArrayList;

public class TransactionProcessing {

	private int productCount;
	private static int capacity;
	private static Product[] cart = new Product[capacity]; // creates a shopping cart storage
	private double totalPrice; // total price of the items in the cart

	public TransactionProcessing() {
		super();
		productCount = 10;
		totalPrice = 0.0;
		capacity = 0;
	}

	public void add(String name, double price, int weight, int quantity) {
//		Product product = new Product(name, price, weight, quantity) {
//		};
		totalPrice += (price * quantity);
//		cart[productCount] = product;
		productCount += 1;
		if (productCount >= capacity) {
			increaseSize();
		}
	}

	public void increaseSize() {
		Product[] product = new Product[capacity + 5];
		for (int i = 0; i < capacity; i++) {
			product[i] = cart[i];
		}
		cart = product;
		product = null;
		capacity = cart.length;
	}

	public static void printLn(String name, double price, int weight, int quantity, double total) {
		System.out.printf("\n%-10.10d %30s %10.2f %10d %10.2f", name, price, weight, quantity, total);
	}

	public static void printHeadings() {
		System.out.printf("\n%-10s 30% %10s %10s %10s %10s", "Name:", "Price:", "Weight:", "Quantity:", "Total:");
	}
}
