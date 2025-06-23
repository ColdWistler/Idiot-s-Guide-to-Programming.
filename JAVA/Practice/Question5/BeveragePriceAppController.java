import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

// Controller class for BeveragePriceApp.fxml
public class BeveragePriceAppController implements Initializable {

    // FXML annotations link these fields to elements in the FXML file using fx:id
    @FXML
    private ChoiceBox<Beverage> beverageChoiceBox;

    @FXML
    private Label priceLabel;

    // ObservableList to hold Beverage objects for the ChoiceBox
    private ObservableList<Beverage> beverages;

    /**
     * Initializes the controller after its root element has been completely processed.
     * This method is automatically called by FXMLLoader.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create Beverage objects
        Beverage tea = new Beverage("Tea", 50.00);
        Beverage coffee = new Beverage("Coffee", 80.00);
        Beverage juice = new Beverage("Juice", 120.00);

        // Populate the ObservableList
        beverages = FXCollections.observableArrayList(tea, coffee, juice);

        // Set the items for the ChoiceBox
        beverageChoiceBox.setItems(beverages);

        // Optionally, pre-select the first item
        if (!beverages.isEmpty()) {
            beverageChoiceBox.getSelectionModel().selectFirst();
        }
    }

    /**
     * Event handler for the "Show Price" button.
     * This method is linked to the button via onAction="#handleShowPrice" in FXML.
     */
    @FXML
    private void handleShowPrice() {
        // Get the selected item from the ChoiceBox
        Beverage selectedBeverage = beverageChoiceBox
            .getSelectionModel()
            .getSelectedItem();

        // Check if an item is actually selected
        if (selectedBeverage != null) {
            // Update the priceLabel with the selected beverage's price
            priceLabel.setText(
                "Price: Rs. " +
                String.format("%.2f", selectedBeverage.getPrice())
            );
        } else {
            // If no item is selected, display a warning message
            priceLabel.setText("No item selected!");
            // Optionally, show an alert dialog for better user feedback
            showAlert(
                "Selection Error",
                "Please select a beverage from the list."
            );
        }
    }

    /**
     * Helper method to show an alert dialog.
     * @param title The title of the alert dialog.
     * @param message The message to display in the alert dialog.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null); // No header
        alert.setContentText(message);
        alert.showAndWait();
    }
}
