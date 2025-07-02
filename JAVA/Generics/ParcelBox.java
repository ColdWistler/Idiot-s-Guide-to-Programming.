public class ParcelBox<T> {
    T item;

    public ParcelBox(T item) {
        this.item = item;
    }

    public void showItemDetails() {
        System.out.println(item.toString());
    }

    public T getItem() {
        return item;
    }
}