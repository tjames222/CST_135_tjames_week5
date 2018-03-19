
/** Project: DrinkClass
 * Summary: Source code for the Drink subclass
 * Class: CST-135
 * Date: March 4, 2018
 * Author: Bug Smasher's group
 * compareTo method added
 * compareTo() internal code written by Samantha Krall, implemented by Phillip Radke
 */
import java.lang.Comparable;
import javafx.scene.image.Image;

public class Drink extends Product implements Comparable<Drink> {

	public Drink() {
		super();
	}

	public Drink(String nameNew, double priceNew, int ouncesNew, int quantity, Image image) {
		this.name = nameNew;
		this.price = priceNew;
		this.weight = ouncesNew;
		this.quantity = quantity;
		this.image = image;
	}

	//Cretes a copy of another Drink
	public Drink(Drink d) {
		this.name = d.name;
		this.price = d.price;
		this.weight = d.weight;
		this.quantity = d.quantity;
		this.dateCreated = d.getDateCreated();
		this.image = d.image;
	}

	//override method for the equals method
	@Override
	public boolean equals(Object o) {
		// Check if the referenced object is of Snack type, then check if the fields are the same.
		if (o instanceof Product) {
			return (name.equals(((Product) o).name))
				  && (price == ((Product) o).price)
				  && (weight == ((Product) o).weight)
				  && (this.getDateCreated().equals(((Product) o).getDateCreated()));
		} else {
			return this == o;
		}
	}

	//override method for the toString method
	public String toString() {
		return "Name: " + name + "\nPrice: " + super.currency.format(price) + "\nWeight: " + this.weight + " FL OZ"
			  + "\nQuantity: " + this.quantity;
	}

	// return of 1 means this drink comes before the compared drink 
	// return of 0 means the two are equal
	// return of -1 means this drink comes after the compared drink
	public int compareTo(Drink drink) {
		if (this.name.charAt(0) > drink.name.charAt(0)) {
			return 1;
		} else if (this.name.charAt(0) < drink.name.charAt(0)) {
			return -1;
		} else if (this.price > drink.price) {
			return 1;
		} else if (this.price < drink.price) {
			return -1;
		} else {
			return 0;
		}
	}
}
