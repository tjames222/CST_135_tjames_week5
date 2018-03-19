
/** Project: GumClass
 * Summary: Source code for the Gum subclass
 * Class: CST-135
 * Date: February 24, 2018
 * Author: Phillip Radke
 */

import javafx.scene.image.Image;

public class Gum extends Snack {
	
	public String flavor;
	//no args constructor
	public Gum () {}
	
	//constructor with args
	public Gum (String name, String flavor, double price, int weight, int qty, Image image) {
		this.name = name;
		this.flavor = flavor;
		this.price = price;
		this.weight = weight;
		this.QuantityOnHand = qty;
		this.image = image;
	}
	
	//Cretes a copy of another Gum
	public Gum (Gum g) {
		this.name = g.name;
		this.price = g.price;
		this.weight = g.weight;
		this.QuantityOnHand = g.QuantityOnHand;
		this.dateCreated = g.getDateCreated();
		this.image = g.image;
	}

	public String getFlavor () {
		return this.flavor;
	}
	
	public void setFlavor (String newFlavor) {
		this.flavor = newFlavor;
	}
	
	//override method for the equals method
	@Override
	public boolean equals (Object o) {
		// Check if the referenced object is of Snack type, then check if the fields are the same.
		if (o instanceof Gum) {
			return (name.equals(((Gum) o).name)) && 
				(price == ((Gum) o).price) &&
				(weight == ((Gum) o).weight) &&
				(this.getDateCreated().equals(((Gum)o).getDateCreated()));
		} else {
			return this == o;
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nFlavor: " + flavor + "\nPrice: " + super.currency.format(price) + "\nWeight: " + this.weight + " OZ";
	}
}
