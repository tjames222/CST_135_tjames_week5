
/** Project: Milestone 4
 * Summary: Source code for Final Sale Page GUI
 * Class: CST-135
 * Date: March 7, 2018
 * Author: Tim James
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mrtim
 */
public class FinalSale extends Application {

	private TransactionProcessing cart = new TransactionProcessing();

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Background image
		BackgroundImage backImg = new BackgroundImage(new Image("file:src/DispenserDesign/Background&ButtonImages/FinalSalePage/FinalSaleBackground.png", 810, 720, false, true),
			  BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			  BackgroundSize.DEFAULT);

		// PANE CREATION
  
                // Home and Back Buttons Pane
		GridPane buttons = new GridPane();
		buttons.setHgap(10);
		buttons.setVgap(10);
		buttons.setPadding(new Insets(0, 10, 0, 10));

                // TableView Cart Pane
		GridPane cartView = new GridPane();
		cartView.setHgap(9);
		cartView.setVgap(9);
		cartView.setOpacity(0.9);
		cartView.setPadding(new Insets(0, 10, 0, 10));
                
                // Delete and Purchase Buttons Pane
                GridPane buttons2 = new GridPane();
		buttons2.setHgap(10);
		buttons2.setVgap(10);
		buttons2.setPadding(new Insets(0, 10, 0, 10));
                                
                // Main Pane for arrangement
                VBox vBox = new VBox();
                vBox.setPadding(new Insets(10, 10, 10, 10));
                vBox.getChildren().addAll(buttons, cartView, buttons2);
                                
                // Background Pane
                StackPane root = new StackPane();
                root.setMaxSize(800, 610);
                root.setMinSize(800, 610);
		root.setBackground(new Background(backImg));
		root.setPadding(new Insets(0, 10, 0, 10));
                root.getChildren().add(vBox);
                
                
		// BUTTON CREATION
                
                //Home Button
		Button home = new Button("", new ImageView(
		  new Image("file:src/DispenserDesign/Background&ButtonImages/NavigationButtons/HomeButton.png")));
		home.setBackground(Background.EMPTY);
                home.setMaxSize(5, 10);
                home.setMinSize(5, 10);
		buttons.add(home, 9, 2);
		//home.setOnAction(e -> {
		//	homePage.setScene(scene); 
                //});
                
                // Back Button
		Button back = new Button("", new ImageView(
		  new Image("file:src/DispenserDesign/Background&ButtonImages/NavigationButtons/BackButton.png")));
		back.setBackground(Background.EMPTY);
                back.setMaxSize(5, 10);
                back.setMinSize(5, 10);
		buttons.add(back, 64, 2);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Back");
			}
		});
	
                // Purchase Button
		Button purchase = new Button("", new ImageView(
		  new Image("file:src/DispenserDesign/Background&ButtonImages/FinalSalePage/Purchase.png")));
		purchase.setBackground(Background.EMPTY);
                purchase.setMaxSize(5, 10);
                purchase.setMinSize(5, 10);
		buttons2.add(purchase, 36, 11);
		purchase.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Purcahse");
			}
		});
                
                // Delete Button
               // Button delete = new Button("Delete Product");
              //  delete.setOnAction(e -> deleteClicked());

		// CREATE TABLE FOR DISPLAYING CART
		TableView<Product> table;
                
		// Name column
		TableColumn<Product, String> nameCol = new TableColumn<>("Name");
		nameCol.setMinWidth(150);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Price column
		TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
		priceCol.setMinWidth(20);
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
                
		// Weight column
		TableColumn<Product, Double> weightCol = new TableColumn<>("Weight");
		weightCol.setMinWidth(50);
		weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));

		// Quantity column
		TableColumn<Product, Double> quantityCol = new TableColumn<>("Quantity");
		quantityCol.setMinWidth(20);
		quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                
		table = new TableView<>();
		table.setItems(getProduct());
		table.setBackground(Background.EMPTY);
		table.setMaxSize(620, 313);
                table.setMinSize(620, 313);
		table.getColumns().addAll(nameCol, priceCol, weightCol, quantityCol);
		cartView.add(table, 7, 18);

		Scene scene = new Scene(root, 800, 710);

		primaryStage.setTitle("Checkout");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
        
        // DELETE BUTTON CLICKED
        // public void deleteClicked() {
        //    ObservableList<Product> productSelected, allProducts;
        //    allProducts = table.getItems();
        //    productSelected = table.getSelectionMode1().getSelectedItems();
            
        //    productSelected.forEach(allProducts::remove);
       // }
        
        
        
	// Shopping cart info view
	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
                // Add to cart button 
                Button addToCart = new Button();
		addToCart.setOnAction(e -> products.add(new Drink("Fanta", 1.75, 16, 1, null)));
                products.add(new Product("DP", 1.75, 16, 1, null) {});
		products.add(new Drink("Coke", 1.75, 16, 1, null));
                products.add(new Snack("Doritos", 1.75, 16, 1, null) {});
                products.add(new Drink("Dasani", 1.75, 16, 2, null));
                products.add(new Drink("Coke", 1.75, 16, 1, null));
                products.add(new ProductImpl("Lays", 1.50, 16, 1, null));
		return products;
	}   
        
        // Make a method that adds up price for total price 
        // totalPrice += (price * quantity);
        

	public static void main(String[] args) {
		launch(args);
	}

    private static class ProductImpl extends Product {

        public ProductImpl(String nameIn, double priceIn, int weightIn, int quantity, Image image) {
            super(nameIn, priceIn, weightIn, quantity, image);
        }
    }

}
