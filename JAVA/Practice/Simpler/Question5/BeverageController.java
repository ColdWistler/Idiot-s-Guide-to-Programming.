import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BeverageController {

    @FXML
    private ComboBox<Beverage> comboBox;

    @FXML
    private Label priceLabel;

    @FXML
    public void initialize() {
        comboBox
            .getItems()
            .addAll(
                new Beverage("Tea", 50),
                new Beverage("Coffee", 80),
                new Beverage("Juice", 120)
            );
    }

    @FXML
    private void handleShowPrice() {
        Beverage selected = comboBox.getValue();
        if (selected != null) {
            priceLabel.setText("Price: Rs. " + selected.getPrice());
        } else {
            priceLabel.setText("No item selected!");
        }
    }
}
