public class Main {

    // Generic method to print items from any shelf
    public static void printShelfItems(ParcelShelf<?> shelf) {
        System.out.println("\n--- Printing all items from shelf ---");
        for (ParcelBox<?> box : shelf.getBoxes()) {
            box.showItemDetails();
        }
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        // Create ParcelBoxes for Electronics
        ParcelBox<Electronics> electronicsBox1 = new ParcelBox<>(new Electronics("Laptop", 12));
        ParcelBox<Electronics> electronicsBox2 = new ParcelBox<>(new Electronics("Headphones", 6));

        // Create ParcelShelf for Electronics and add boxes
        ParcelShelf<Electronics> electronicsShelf = new ParcelShelf<>();
        electronicsShelf.addBox(electronicsBox1);
        electronicsShelf.addBox(electronicsBox2);

        System.out.println("Electronics Shelf Contents:");
        electronicsShelf.printAllBoxes();

        // Create ParcelBoxes for Books
        ParcelBox<Book> bookBox1 = new ParcelBox<>(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
        ParcelBox<Book> bookBox2 = new ParcelBox<>(new Book("Pride and Prejudice", "Jane Austen"));

        // Create ParcelShelf for Books and add boxes
        ParcelShelf<Book> bookShelf = new ParcelShelf<>();
        bookShelf.addBox(bookBox1);
        bookShelf.addBox(bookBox2);

        System.out.println("\nBook Shelf Contents:");
        bookShelf.printAllBoxes();

        // Create ParcelBoxes for Food
        ParcelBox<Food> foodBox1 = new ParcelBox<>(new Food("Milk", "2025-07-10"));
        ParcelBox<Food> foodBox2 = new ParcelBox<>(new Food("Bread", "2025-07-05"));

        // Create ParcelShelf for Food and add boxes
        ParcelShelf<Food> foodShelf = new ParcelShelf<>();
        foodShelf.addBox(foodBox1);
        foodShelf.addBox(foodBox2);

        System.out.println("\nFood Shelf Contents:");
        foodShelf.printAllBoxes();

        // Use the generic printShelfItems method
        printShelfItems(electronicsShelf);
        printShelfItems(bookShelf);
        printShelfItems(foodShelf);
    }
}