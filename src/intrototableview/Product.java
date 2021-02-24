package intrototableview;

/**
 *
 * @author Obituary
 */
// name price quantity one column for each 
public class Product {

    private String name;
    private double price;
    private int quantity;

    // 2 constructors 2nd overload the first one
    // default values
    public Product() {
        this.name = "";
        this.price = 0;
        this.quantity = 0;

    }
    // set one blank product and then set all properties one by one or
    // do everything all in one: overloaded
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    // insert all setters and getters alt insert
    // conventions get + property

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
