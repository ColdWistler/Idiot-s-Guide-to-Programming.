// Beverage.java
// Represents a beverage with a name and price.
public class Beverage {

    private String name;
    private double price;

    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Override toString() to display the beverage name in the JComboBox.
    @Override
    public String toString() {
        return name;
    }
}
