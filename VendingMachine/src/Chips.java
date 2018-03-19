
/** Project: ChipsClass
 * Summary: Source code for the Drink subclass
 * Class: CST-135
 * Date: February 24, 2018
 * Author: Samantha Krall
 * Alterations made: Moved class out of the Main class and made the class its own class
 *	Changed name conventions and format to match the rest of the project
 *	Removed unnecessary get and set methods for compatibility with superclass
 *	Added the equals override method
 *	Added no args constructor
 * Altered by: Phillip Radke
 */
import javafx.scene.image.Image;

public class Chips extends Snack {
	
	public Chips () {
		super();
	}

	public Chips(String name, double price, int weight, int quantity, Image image) {
		super(name, price, weight, quantity, image);
	}
	
	//Cretes a copy of another Chips
	public Chips (Chips c) {
		this.name = c.name;
		this.price = c.price;
		this.weight = c.weight;
		this.QuantityOnHand = c.QuantityOnHand;
		this.dateCreated = c.getDateCreated();
		this.image = c.image;
	}
	
	//override method for the equals method
	@Override
	public boolean equals (Object o) {
		// Check if the referenced object is of Snack type, then check if the fields are the same.
		if (o instanceof Chips) {
			return (name.equals(((Chips) o).name)) && 
				(price == ((Chips) o).price) &&
				(weight == ((Chips) o).weight) &&
				(this.getDateCreated().equals(((Chips)o).getDateCreated()));
		} else {
			return this == o;
		}
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nPrice: " + super.currency.format(price) + "\nWeight: " + this.weight + " OZ";
	}
}
