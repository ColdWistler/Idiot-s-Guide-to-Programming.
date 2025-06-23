// StationeryItem.java
// Represents a stationery item with a name and price.
public class StationeryItem {

    private String name;
    private double price;

    public StationeryItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Override toString() to display the item name in the ComboBox (JavaFX choice box).
    @Override
    public String toString() {
        return name;
    }
}
