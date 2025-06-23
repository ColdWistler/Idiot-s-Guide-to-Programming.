import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StationeryController {

    @FXML
    private ComboBox<StationeryItem> comboBox;

    @FXML
    private Label priceLabel;

    @FXML
    private void initialize() {
        comboBox
            .getItems()
            .addAll(
                new StationeryItem("Pen", 20),
                new StationeryItem("Notebook", 100),
                new StationeryItem("Marker", 60)
            );
    }

    @FXML
    private void handleShowPrice() {
        StationeryItem item = comboBox.getValue();
        if (item != null) {
            priceLabel.setText("Price: Rs. " + item.getPrice());
        } else {
            priceLabel.setText("No item selected!");
        }
    }
}
