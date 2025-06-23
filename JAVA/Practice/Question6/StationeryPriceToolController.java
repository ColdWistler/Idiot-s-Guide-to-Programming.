import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

// Controller class for StationeryPriceTool.fxml
public class StationeryPriceToolController implements Initializable {

    // FXML annotations link these fields to elements in the FXML file using fx:id
    @FXML
    private ChoiceBox<StationeryItem> itemChoiceBox;

    @FXML
    private Label priceLabel;

    // ObservableList to hold StationeryItem objects for the ChoiceBox
    private ObservableList<StationeryItem> items;

    /**
     * Initializes the controller after its root element has been completely processed.
     * This method is automatically called by FXMLLoader.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create StationeryItem objects
        StationeryItem pen = new StationeryItem("Pen", 20.00);
        StationeryItem notebook = new StationeryItem("Notebook", 100.00);
        StationeryItem marker = new StationeryItem("Marker", 60.00);

        // Populate the ObservableList
        items = FXCollections.observableArrayList(pen, notebook, marker);

        // Set the items for the ChoiceBox
        itemChoiceBox.setItems(items);

        // Optionally, pre-select the first item
        if (!items.isEmpty()) {
            itemChoiceBox.getSelectionModel().selectFirst();
        }
    }

    /**
     * Event handler for the "Show Price" button.
     * This method is linked to the button via onAction="#handleShowPrice" in FXML.
     */
    @FXML
    private void handleShowPrice() {
        // Get the selected item from the ChoiceBox
        StationeryItem selectedItem = itemChoiceBox
            .getSelectionModel()
            .getSelectedItem();

        // Check if an item is actually selected
        if (selectedItem != null) {
            // Update the priceLabel with the selected item's price
            priceLabel.setText(
                "Price: Rs. " + String.format("%.2f", selectedItem.getPrice())
            );
        } else {
            // If no item is selected, display a warning message
            priceLabel.setText("No item selected!");
            // Show an alert dialog for better user feedback
            showAlert(
                "Selection Error",
                "Please select an item from the list."
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
