import java.util.ArrayList;
import java.util.List;

public class ParcelShelf<T> {
    List<ParcelBox<T>> boxes;

    public ParcelShelf() {
        this.boxes = new ArrayList<>();
    }

    public void addBox(ParcelBox<T> box) {
        boxes.add(box);
    }

    public void removeBox(int index) {
        if (index >= 0 && index < boxes.size()) {
            boxes.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void printAllBoxes() {
        if (boxes.isEmpty()) {
            System.out.println("Shelf is empty.");
            return;
        }
        for (ParcelBox<T> box : boxes) {
            box.showItemDetails();
        }
    }

    public List<ParcelBox<T>> getBoxes() {
        return boxes;
    }
}