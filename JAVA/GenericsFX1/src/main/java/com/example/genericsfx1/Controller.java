package com.example.genericsfx1; // Changed package name

import com.example.genericsfx1.model.Book;
import com.example.genericsfx1.model.Electronics;
import com.example.genericsfx1.model.Food;
import com.example.genericsfx1.util.ParcelBox;
import com.example.genericsfx1.util.ParcelShelf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> itemTypeComboBox;
    @FXML
    private ComboBox<String> shelfTypeComboBox;
    @FXML
    private ListView<ParcelBox<?>> shelfListView;

    private Map<String, ParcelShelf<?>> shelves = new HashMap<>();
    private ObservableList<ParcelBox<?>> currentShelfItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemTypeComboBox.setItems(FXCollections.observableArrayList("Electronics", "Book", "Food"));
        itemTypeComboBox.getSelectionModel().selectFirst();

        shelves.put("Electronics Shelf", new ParcelShelf<Electronics>());
        shelves.put("Book Shelf", new ParcelShelf<Book>());
        shelves.put("Food Shelf", new ParcelShelf<Food>());

        shelfTypeComboBox.setItems(FXCollections.observableArrayList(shelves.keySet()));
        shelfTypeComboBox.getSelectionModel().selectFirst();

        shelfListView.setItems(currentShelfItems);

        shelfTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            updateShelfView(newVal);
        });

        updateShelfView(shelfTypeComboBox.getSelectionModel().getSelectedItem());
    }

    private void updateShelfView(String selectedShelfName) {
        if (selectedShelfName != null) {
            ParcelShelf<?> selectedShelf = shelves.get(selectedShelfName);
            currentShelfItems.clear();
            if (selectedShelf != null) {
                currentShelfItems.addAll(selectedShelf.getBoxes());
            }
        }
    }

    @FXML
    private void handleAddSampleItem() {
        String selectedItemType = itemTypeComboBox.getSelectionModel().getSelectedItem();
        String selectedShelfName = shelfTypeComboBox.getSelectionModel().getSelectedItem();

        if (selectedItemType == null || selectedShelfName == null) {
            System.out.println("Please select both item type and shelf type.");
            return;
        }

        ParcelShelf<?> currentGenericShelf = shelves.get(selectedShelfName);

        switch (selectedItemType) {
            case "Electronics":
                if (currentGenericShelf instanceof ParcelShelf) {
                    @SuppressWarnings("unchecked")
                    ParcelShelf<Electronics> electronicsShelf = (ParcelShelf<Electronics>) currentGenericShelf;
                    electronicsShelf.addBox(new ParcelBox<>(new Electronics("New Gadget", (int) (Math.random() * 24) + 6)));
                }
                break;
            case "Book":
                if (currentGenericShelf instanceof ParcelShelf) {
                    @SuppressWarnings("unchecked")
                    ParcelShelf<Book> bookShelf = (ParcelShelf<Book>) currentGenericShelf;
                    bookShelf.addBox(new ParcelBox<>(new Book("New Story " + System.currentTimeMillis() % 1000, "Author " + System.currentTimeMillis() % 100)));
                }
                break;
            case "Food":
                if (currentGenericShelf instanceof ParcelShelf) {
                    @SuppressWarnings("unchecked")
                    ParcelShelf<Food> foodShelf = (ParcelShelf<Food>) currentGenericShelf;
                    foodShelf.addBox(new ParcelBox<>(new Food("Fresh Item " + System.currentTimeMillis() % 1000, "2025-12-31")));
                }
                break;
        }
        updateShelfView(selectedShelfName);
    }

    @FXML
    private void handleRemoveItem() {
        int selectedIndex = shelfListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String selectedShelfName = shelfTypeComboBox.getSelectionModel().getSelectedItem();
            if (selectedShelfName != null) {
                ParcelShelf<?> currentGenericShelf = shelves.get(selectedShelfName);
                if (currentGenericShelf != null) {
                    currentGenericShelf.removeBox(selectedIndex);
                    updateShelfView(selectedShelfName);
                }
            }
        } else {
            System.out.println("No item selected for removal.");
        }
    }
}