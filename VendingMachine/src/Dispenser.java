
/** Project: DispenserClass
 * Summary: Source code for the Dispenser class
 * Class: CST-135
 * Date: February 24, 2018
 * Author: Phillip Radke
 */

import javafx.scene.image.Image;

public class Dispenser {

	private int penniesAvailable, nickelsAvailable, dimesAvailable, quartersAvailable, dollarsAvailable;
	public Product[] productsForSale;

	//no args constructor
	public Dispenser() {
		//Fill the Dispenser with cash
		this.penniesAvailable = 100;
		this.nickelsAvailable = 100;
		this.dimesAvailable = 100;
		this.quartersAvailable = 100;
		this.dollarsAvailable = 35;

		//Instantiate and fill the Product array
		productsForSale = new Product[20];

		productsForSale[ 0] = new Drink("Coke", 1.75, 16, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/CokePicture.png"));
		productsForSale[ 1] = new Drink("Powerade", 1.75, 16, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/DrinkPowerade.png"));
		productsForSale[ 2] = new Chips("Lays Classic", 1.75, 15, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/laysclassic.png"));
		productsForSale[ 3] = new Chips("Lays Barbecue", 1.75, 15, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/laysbarbecue.png"));
		productsForSale[ 4] = new Gum("Wriggleys", "Big Red", .75, 5, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/BigRedGum.jpg"));
		productsForSale[ 5] = new Drink("Sprite", 1.75, 16, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/DrinkSprite.png"));
		productsForSale[ 6] = new Drink("Fanta", 1.75, 16, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/DrinkFanta.png"));
		productsForSale[ 7] = new Candy("Butterfinger", 1.00, 7, 5, new Image(
			  "file:src/DispenserDesign/IndividualProducts/butterfinger.png"));
		productsForSale[ 8] = new Candy("Snickers", 1.00, 7, 5, new Image(
			  "file:src/DispenserDesign/IndividualProducts/snickers.png"));
		productsForSale[ 9] = new Candy("KitKat", 1.00, 7, 5, new Image(
			  "file:src/DispenserDesign/IndividualProducts/KitKat.png"));
		productsForSale[10] = new Candy("PayDay", 1.00, 7, 5, new Image(
			  "file:src/DispenserDesign/IndividualProducts/payday.png"));
		productsForSale[11] = new Candy("Nature Valley Bar", 1.00, 7, 5, new Image(
			  "file:src/DispenserDesign/IndividualProducts/NatureValley.png"));
		productsForSale[12] = new Chips("Doritos", 1.75, 15, 10, new Image(
			  "file:src/DispenserDesign/IndividualProducts/Doritos.png"));
		productsForSale[14] = new Chips("Ruffles All Dressed", 1.75, 15, 15, new Image(
			  "file:src/DispenserDesign/IndividualProducts/rufflesalldressed.png"));
		productsForSale[15] = new Chips("Ruffles Queso", 1.75, 15, 13, new Image(
			  "file:src/DispenserDesign/IndividualProducts/rufflesquesocheese.png"));
		productsForSale[16] = new Gum("Wriggleys", "Spearmint", .75, 1, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/SpearmintGum.jpg"));
		productsForSale[17] = new Gum("trident", "Sugar Free", .75, 3, 20, new Image(
			  "file:src/DispenserDesign/IndividualProducts/TridentGum.jpg"));
		productsForSale[18] = new Drink("Dasani", 1.50, 16, 12, new Image(
			  "file:src/DispenserDesign/IndividualProducts/WaterPicture.png"));
	}

	public void setPenniesAvailable(int newAmount) {
		this.penniesAvailable = newAmount;
	}

	public void setNickelsAvailable(int newAmount) {
		this.nickelsAvailable = newAmount;
	}

	public void setDimesAvailable(int newAmount) {
		this.dimesAvailable = newAmount;
	}

	public void setQuartersAvailable(int newAmount) {
		this.quartersAvailable = newAmount;
	}

	public void setDollarsAvailable(int newAmount) {
		this.dollarsAvailable = newAmount;
	}

	//Calculate how much cash is available in the machine
	public double getCashOnHand() {
		double cash = this.dollarsAvailable;

		cash += this.penniesAvailable / 100;
		cash += (this.nickelsAvailable * 5) / 100;
		cash += (this.dimesAvailable * 10) / 100;
		cash += (this.quartersAvailable * 25) / 100;

		return cash;
	}

	public Product getProduct(int index) {
		return this.productsForSale[index];
	}

	public void displayProducts() {
		for (int i = 0; i < productsForSale.length; i++) {
			System.out.println(productsForSale[i].toString());
		}
	}
}
