package intrototableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Obituary
 */
public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Introduction to TableView");

        //Name column
        // 2 parameters, one type in the table, 2 what type of data is going to be in that column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        // for the name column use name property of the object (all values of their name: laptop, bouncy ball etc)
        // name MUST CORRESPOND TO THE OBJECT NAME "name"
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));

        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));

        //Name Input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price Input 
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        //Quantity Input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(100);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        HBox hBox = new HBox();
        // top right bottom left, set padding for entire layout not the items themselves
        hBox.setPadding(new Insets(10, 10, 10, 10));
        // items spacing
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        // get all of these products as ObservableList
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        // Layout 
        VBox layout = new VBox();
        layout.getChildren().addAll(table, hBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }

    // Add button clicked
    public void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();

    }

    //delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        // this is going to return any item selected
        productSelected = table.getSelectionModel().getSelectedItems(); 
        
        productSelected.forEach(allProducts::remove);
        
    }
    // Get all the products
    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Bouncy Ball", 2.49, 198));
        products.add(new Product("Toilet", 99.50, 74));
        products.add(new Product("The Notebook DVD", 19.80, 12));
        products.add(new Product("Corn", 1.49, 846));
        return products;
    }
}
