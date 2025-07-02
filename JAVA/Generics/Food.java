public class Food {
    String name;
    String expiryDate;

    public Food(String name, String expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Food [Name: " + name + ", Expiry Date: " + expiryDate + "]";
    }
}